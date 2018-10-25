package com.che.dao;

import com.che.model.TripDriverOrder;

public interface TripDriverOrderDao {

    int deleteByPrimaryKey(Long orderId);

    int insert(TripDriverOrder record);

    TripDriverOrder selectByOrderId(Long orderId);

    TripDriverOrder selectByTripId(Long tripId);

    int updateByPrimaryKeySelective(TripDriverOrder record);
}