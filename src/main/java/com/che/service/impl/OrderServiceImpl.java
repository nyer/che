package com.che.service.impl;

import com.che.constant.OrderStatus;
import com.che.dao.OrderDao;
import com.che.dto.OrderDto;
import com.che.model.Order;
import com.che.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        order.setStatus(OrderStatus.UN_PAY.getStatus());
        order.setCreateTime(current);
        order.setUpdateTime(current);
        this.orderDao.insert(order);

        orderDto.setOrderId(order.getOrderId());
    }

    @Transactional
    @Override
    public void payOrder(Long orderId) {

        if (matchOrderStatus(orderId, OrderStatus.PAYED)) {

            return;
        }

        this.updateOrderStatus(orderId, OrderStatus.UN_PAY, OrderStatus.PAYED);
    }

    @Transactional
    @Override
    public void cancelOrder(Long orderId) {

        if (matchOrderStatus(orderId, OrderStatus.CANCEL)) {

            return;
        }

        this.updateOrderStatus(orderId, OrderStatus.UN_PAY, OrderStatus.CANCEL);
    }

    void updateOrderStatus(Long orderId, OrderStatus fromStatus, OrderStatus toStatus) {

        int count = this.orderDao.updateOrderStatus(orderId, fromStatus.getStatus(), toStatus.getStatus());
        if (count != 1) {

            throw new RuntimeException("updateOrderStatus db error");
        }
    }

    private boolean matchOrderStatus(Long orderId, OrderStatus orderStatus) {

        Order order = getOrderById(orderId);
        if (order.getStatus() == orderStatus.getStatus()) {
            // 保持幂等性
            return true;
        }

        return false;
    }

    Order getOrderById(Long orderId) {

        return this.orderDao.selectByOrderId(orderId);
    }
}
