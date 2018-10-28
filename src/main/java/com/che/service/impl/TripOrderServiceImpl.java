package com.che.service.impl;

import com.che.constant.DriverGorderStatus;
import com.che.constant.DriverOrderStatus;
import com.che.dao.TripDriverGorderDao;
import com.che.dao.TripDriverOrderDao;
import com.che.dto.OrderDto;
import com.che.dto.TripCarDto;
import com.che.dto.TripDriverOrderDto;
import com.che.dto.TripPassengerDto;
import com.che.model.Trip;
import com.che.model.TripDriverGorder;
import com.che.model.TripDriverOrder;
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

@Service
public class TripOrderServiceImpl implements TripOrderService, BeanSelfAware {

    @Resource
    private TripService tripService;

    @Resource
    private TripDriverGorderDao tripDriverGorderDao;

    @Resource
    private TripDriverOrderDao tripDriverOrderDao;

    @Resource
    private OrderService orderService;

    private TripOrderService self;

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
        TripDriverOrderDto driverOrderDto = new TripDriverOrderDto();
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
        TripDriverOrder tripDriverOrder = new TripDriverOrder();
        tripDriverOrder.setOrderId(driverOrderDto.getOrderId());
        tripDriverOrder.setPassengerOrderId(passengerOrderDto.getOrderId());
        this.tripDriverOrderDao.updateByPrimaryKeySelective(tripDriverOrder);
    }

    @Override
    public TripDriverOrder getDriverOrderByTripId(Long tripId) {

        return tripDriverOrderDao.selectByTripId(tripId);
    }

    @Override
    public void createDriverOrder(TripDriverOrderDto tripDriverOrderDto) {

        Long current = System.currentTimeMillis();

        TripDriverGorder tripDriverGorder = new TripDriverGorder();
        tripDriverGorder.setTripId(tripDriverOrderDto.getDriverTripId());
        tripDriverGorder.setUserId(tripDriverOrderDto.getUserId());
        tripDriverGorder.setStatus(DriverGorderStatus.NOT_START.getStatus());
        tripDriverGorder.setCreateTime(current);
        tripDriverGorder.setUpdateTime(current);
        this.tripDriverGorderDao.insert(tripDriverGorder);
        tripDriverOrderDto.setGorderId(tripDriverGorder.getGorderId());

        TripDriverOrder order = new TripDriverOrder();
        order.setGorderId(tripDriverGorder.getGorderId());
        order.setUserId(tripDriverOrderDto.getUserId());
        order.setDriverTripId(tripDriverOrderDto.getDriverTripId());
        order.setTripId(tripDriverOrderDto.getTripId());
        order.setStatus(DriverOrderStatus.UN_ARRIVE.getStatus());
        order.setCreateTime(current);
        order.setUpdateTime(current);

        this.tripDriverOrderDao.insert(order);

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
