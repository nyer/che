package com.che.dao;

import com.che.model.TripCar;

public interface TripCarDao {

    int insert(TripCar record);

    int decSeatCount(Long tripId, int decCount);

    int updateByPrimaryKeySelective(TripCar record);

    TripCar selectByTripId(Long tripId);
}