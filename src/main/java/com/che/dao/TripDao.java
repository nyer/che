package com.che.dao;

import com.che.model.Trip;

public interface TripDao {
    int deleteByPrimaryKey(Long tripId);

    int insert(Trip record);

    int updateByPrimaryKeySelective(Trip record);
}