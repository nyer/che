package com.che.service;

import com.che.dto.TripDriverOrderDto;
import com.che.dto.TripOrderDto;
import com.che.model.TripDriverOrder;

public interface OrderService {


    TripDriverOrder getDriverOrderByTripId(Long tripId);

    void createDriverOrder(TripDriverOrderDto tripDriverOrderDto);

    /**
     * 创建班次订单
     * @param tripOrder
     * @return
     */
    void createPassengerOrder(TripOrderDto tripOrder);
}
