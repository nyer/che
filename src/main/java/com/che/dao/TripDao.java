package com.che.dao;

import com.che.model.Trip;

import java.util.List;

public interface TripDao {
    int deleteByPrimaryKey(Long tripId);

    int insert(Trip record);

    int updateByPrimaryKeySelective(Trip record);

    int updateOrderId(Long tripId, Long orderId);

    List<Trip> selectByTripIdList(List<Long> tripIdList);
}