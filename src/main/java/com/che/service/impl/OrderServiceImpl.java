package com.che.service.impl;

import com.che.constant.OrderStatus;
import com.che.dao.OrderDao;
import com.che.dto.OrderDto;
import com.che.model.Order;
import com.che.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单Service
 * @author leiting
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public void createOrder(OrderDto orderDto) {

        Long current = System.currentTimeMillis();
        Order order = new Order();
        order.setUserId(orderDto.getUserId());
        order.setBusType(orderDto.getBusType());
        order.setBusOrderId(orderDto.getBusOrderId());
        order.setStatus(OrderStatus.UNPAY.getStatus());
        order.setCreateTime(current);
        order.setUpdateTime(current);
        this.orderDao.insert(order);

        orderDto.setOrderId(order.getOrderId());
    }
}
