package com.che.service;

import com.che.dto.OrderDto;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    void payOrder(Long orderId);

    @Transactional
    void cancelOrder(Long orderId);
}
