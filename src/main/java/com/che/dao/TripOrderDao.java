package com.che.dao;

import com.che.model.TripOrder;

public interface TripOrderDao {

    int deleteByPrimaryKey(Long orderId);

    int insert(TripOrder record);

    TripOrder selectByOrderId(Long orderId);

    TripOrder selectByTripId(Long tripId);

    int updateByPrimaryKeySelective(TripOrder record);

    int updateOrderStatus(Long orderId, Integer fromStatus, Integer toStatus);
}