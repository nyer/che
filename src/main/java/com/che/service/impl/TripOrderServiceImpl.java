package com.che.service.impl;

import com.che.constant.TripGorderStatus;
import com.che.constant.TripOrderStatus;
import com.che.dao.TripGorderDao;
import com.che.dao.TripOrderDao;
import com.che.dto.OrderDto;
import com.che.dto.TripCarDto;
import com.che.dto.TripOrderDto;
import com.che.dto.TripPassengerDto;
import com.che.model.Trip;
import com.che.model.TripGorder;
import com.che.model.TripOrder;
import com.che.service.OrderService;
import com.che.service.TripOrderService;
import com.che.service.TripService;
import com.che.service.bean.BeanSelfAware;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 行程订单Service
 * @author leiting
 */
@Service
public class TripOrderServiceImpl implements TripOrderService, BeanSelfAware {

    @Resource
    private TripService tripService;

    @Resource
    private TripGorderDao tripGorderDao;

    @Resource
    private TripOrderDao tripOrderDao;

    @Resource
    private OrderService orderService;

    private TripOrderService self;

    void updateTripOrderStatus(Long orderId, TripOrderStatus fromStatus, TripOrderStatus toStatus) {

        int count = tripOrderDao.updateOrderStatus(orderId, fromStatus.getStatus(), toStatus.getStatus());
        if (count != 1) {

            throw new RuntimeException("更新订单状态失败");
        }
    }

    @Transactional
    @Override
    public void departureStationArrived(Long orderId) {

        if (matchOrderStatus(orderId, TripOrderStatus.ARRIVED)) {

            return;
        }
        this.updateTripOrderStatus(orderId, TripOrderStatus.UN_ARRIVE, TripOrderStatus.ARRIVED);
    }

    @Transactional
    @Override
    public void passengerOnBoard(Long orderId) {

        if (matchOrderStatus(orderId, TripOrderStatus.PASSENGER_ABOARD)) {

            return;
        }
        this.updateTripOrderStatus(orderId, TripOrderStatus.ARRIVED, TripOrderStatus.PASSENGER_ABOARD);
    }

    @Transactional
    @Override
    public void destStationArrived(Long orderId) {

        if (matchOrderStatus(orderId, TripOrderStatus.DEST_ARRIVED)) {

            return;
        }
        this.updateTripOrderStatus(orderId, TripOrderStatus.PASSENGER_ABOARD, TripOrderStatus.DEST_ARRIVED);
    }

    @Transactional
    @Override
    public void cancelOrder(Long orderId) {

        TripOrder tripOrder = getOrderByOrderId(orderId);
        if (matchOrderStatus(tripOrder, TripOrderStatus.CANCEL)) {

            return;
        }

        TripOrderStatus orderStatus = TripOrderStatus.getByStatus(tripOrder.getStatus());
        if (orderStatus != TripOrderStatus.UN_ARRIVE && orderStatus != TripOrderStatus.ARRIVED) {

            throw new RuntimeException("订单状态错误");
        }

        this.updateTripOrderStatus(orderId, orderStatus, TripOrderStatus.CANCEL);

        this.orderService.cancelOrder(tripOrder.getPassengerOrderId());
    }

    private boolean matchOrderStatus(Long orderId, TripOrderStatus tripOrderStatus) {

        TripOrder tripOrder = getOrderByOrderId(orderId);
        if (tripOrder.getStatus() == tripOrderStatus.getStatus()) {
            // 保持幂等性
            return true;
        }

        return false;
    }

    private boolean matchOrderStatus(TripOrder tripOrder, TripOrderStatus tripOrderStatus) {

        if (tripOrder.getStatus() == tripOrderStatus.getStatus()) {
            // 保持幂等性
            return true;
        }

        return false;
    }

    @Override
    public void createOrder(Long driverTripId, Long passengerTripId) {

        List<Trip> tripList = tripService.getTripList(Arrays.asList(driverTripId, passengerTripId));
        Map<Long, Trip> tripMap = Maps.uniqueIndex(tripList, new Function<Trip, Long>() {
            @Override
            public Long apply(@Nullable Trip trip) {
                return trip.getTripId();
            }
        });

        Trip driverTrip = tripMap.get(driverTripId);
        Trip passengerTrip = tripMap.get(passengerTripId);

        // 检验行程信息是否存在，状态是否正确
        // TODO
        TripPassengerDto tripPassengerDto = tripService.getTripPassengerDto(passengerTripId);
        TripCarDto tripCar = tripService.getTripCarDto(driverTripId);
        if (tripCar.getSpareSeatCount() < tripPassengerDto.getPassengerCount()) {

            throw new RuntimeException("车座位不够, driverTripId: " + driverTrip.getTripId());
        }

        self.doCreateOrder(driverTrip, tripCar, passengerTrip, tripPassengerDto);
    }

    @Transactional
    @Override
    public void doCreateOrder(Trip driverTrip, TripCarDto tripCar, Trip passengerTrip, TripPassengerDto tripPassengerDto) {

        int count = tripService.decSeatCount(tripCar.getTripId(), tripPassengerDto.getPassengerCount());
        if (count <= 0) {

            throw new RuntimeException("车无空座位, driverTripId: " + driverTrip.getTripId() + ", passengerDripId: " + passengerTrip.getTripId());
        }

        // 创建司机订单
        TripOrderDto driverOrderDto = new TripOrderDto();
        driverOrderDto.setTripId(passengerTrip.getTripId());
        driverOrderDto.setDriverTripId(driverTrip.getTripId());
        driverOrderDto.setUserId(driverTrip.getUserId());
        this.createDriverOrder(driverOrderDto);

        OrderDto passengerOrderDto = new OrderDto();
        passengerOrderDto.setBusType(1);
        passengerOrderDto.setBusOrderId(driverOrderDto.getOrderId() + "");
        passengerOrderDto.setUserId(passengerTrip.getUserId());
        this.createPassengerOrder(passengerOrderDto);

        // 更新DriverOrder的passengerOrderId
        TripOrder tripDriverOrder = new TripOrder();
        tripDriverOrder.setOrderId(driverOrderDto.getOrderId());
        tripDriverOrder.setPassengerOrderId(passengerOrderDto.getOrderId());
        this.tripOrderDao.updateByPrimaryKeySelective(tripDriverOrder);
    }

    @Override
    public TripOrder getDriverOrderByTripId(Long tripId) {

        return tripOrderDao.selectByTripId(tripId);
    }

    TripOrder getOrderByOrderId(Long orderId) {

        return tripOrderDao.selectByOrderId(orderId);
    }

    @Override
    public void createDriverOrder(TripOrderDto tripDriverOrderDto) {

        Long current = System.currentTimeMillis();

        TripGorder tripDriverGorder = new TripGorder();
        tripDriverGorder.setTripId(tripDriverOrderDto.getDriverTripId());
        tripDriverGorder.setUserId(tripDriverOrderDto.getUserId());
        tripDriverGorder.setStatus(TripGorderStatus.NOT_START.getStatus());
        tripDriverGorder.setCreateTime(current);
        tripDriverGorder.setUpdateTime(current);
        this.tripGorderDao.insert(tripDriverGorder);
        tripDriverOrderDto.setGorderId(tripDriverGorder.getGorderId());

        TripOrder order = new TripOrder();
        order.setGorderId(tripDriverGorder.getGorderId());
        order.setUserId(tripDriverOrderDto.getUserId());
        order.setDriverTripId(tripDriverOrderDto.getDriverTripId());
        order.setTripId(tripDriverOrderDto.getTripId());
        order.setStatus(TripOrderStatus.UN_ARRIVE.getStatus());
        order.setCreateTime(current);
        order.setUpdateTime(current);

        this.tripOrderDao.insert(order);

        tripDriverOrderDto.setOrderId(order.getOrderId());
    }

    public void createPassengerOrder(OrderDto tripOrderDto) {

        orderService.createOrder(tripOrderDto);
    }

    @Override
    public void setSelf(Object proxyBean) {

        this.self = (TripOrderService) proxyBean;
    }
}
