package com.che.dao;

import com.che.model.Order;

public interface OrderDao {

    int insert(Order record);

    int updateByPrimaryKeySelective(Order record);

    int updateOrderStatus(Long orderId, Integer fromStatus, Integer toStatus);

    Order selectByOrderId(Long orderId);
}