package com.che.service.impl;

import com.che.dao.TripDao;
import com.che.dto.TripDto;
import com.che.service.OrderService;
import com.che.service.TripService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TripServiceImpl implements TripService {

    @Resource
    private TripDao tripDao;

    @Resource
    private OrderService orderService;

    @Override
    public void addTrip(TripDto tripDto) {

        this.orderService.createOrder(tripDto);
    }
}
