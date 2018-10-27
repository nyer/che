package com.che.dao;

import com.che.model.TripPassenger;

public interface TripPassengerDao {

    int insert(TripPassenger record);

    int updateByPrimaryKeySelective(TripPassenger record);

    TripPassenger selectByTripId(Long tripId);
}