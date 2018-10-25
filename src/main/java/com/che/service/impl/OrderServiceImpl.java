package com.che.service.impl;

import com.che.constant.OrderStatus;
import com.che.dao.TripDriverOrderDao;
import com.che.dao.TripOrderDao;
import com.che.dto.TripDriverOrderDto;
import com.che.dto.TripOrderDto;
import com.che.model.TripDriverOrder;
import com.che.model.TripOrder;
import com.che.service.OrderService;
import com.che.service.bean.BeanSelfAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单Service
 * @author leiting
 */
@Service
public class OrderServiceImpl implements OrderService, BeanSelfAware {

    @Resource
    private TripOrderDao tripOrderDao;

    @Resource
    private TripDriverOrderDao tripDriverOrderDao;

    private OrderService self;

    @Override
    public TripDriverOrder getDriverOrderByTripId(Long tripId) {

        return tripDriverOrderDao.selectByTripId(tripId);
    }

    @Override
    public void createDriverOrder(TripDriverOrderDto tripDriverOrderDto) {

        Long current = System.currentTimeMillis();
        TripDriverOrder order = new TripDriverOrder();
        order.setUserId(tripDriverOrderDto.getUserId());
        order.setTripId(tripDriverOrderDto.getTripDto().getTripId());
        order.setCreateTime(current);
        order.setUpdateTime(current);

        this.tripDriverOrderDao.insert(order);

        tripDriverOrderDto.setOrderId(order.getOrderId());
    }

    @Override
    public void createPassengerOrder(TripOrderDto tripOrderDto) {

        Long current = System.currentTimeMillis();
        TripOrder order = new TripOrder();
        order.setUserId(tripOrderDto.getUserId());
        order.setTripId(tripOrderDto.getTripDto().getTripId());
        order.setDriverOrderId(tripOrderDto.getDriverOrderId());
        order.setStatus(OrderStatus.WAITING_CAR.getStatus());
        order.setCreateTime(current);
        order.setUpdateTime(current);

        this.tripOrderDao.insert(order);

        tripOrderDto.setOrderId(order.getOrderId());
    }

    @Override
    public void setSelf(Object proxyBean) {

        this.self = (OrderService) proxyBean;
    }
}
