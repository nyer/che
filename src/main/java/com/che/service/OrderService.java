package com.che.service;

import com.che.dto.OrderDto;

/**
 * 前台订单Service
 * @author leiting
 */
public interface OrderService {

    /**
     * 创建前台订单
     * @param order
     * @return
     */
    void createOrder(OrderDto orderDto);
}
