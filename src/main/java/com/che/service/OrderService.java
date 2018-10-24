package com.che.service;

import com.che.dto.TripDto;
import com.che.dto.TripOrderDto;
import com.che.model.TripGorder;
import com.che.model.TripOrder;

import java.util.List;

public interface OrderService {

    /**
     * 创建大订单
     * @param userId
     * @param orders
     * @return
     */
    TripGorder createGorder(Long userId, List<TripOrder> orders);

    void doCreateGorder(TripGorder gorder);

    /**
     * 创建班次订单
     * @param tripOrder
     * @return
     */
    void createOrder(TripOrderDto tripOrder);
}
