package com.che.service;

import com.che.dto.TripCarDto;
import com.che.dto.TripDriverOrderDto;
import com.che.dto.TripPassengerDto;
import com.che.model.Trip;
import com.che.model.TripDriverOrder;
import org.springframework.transaction.annotation.Transactional;

public interface TripOrderService {

    void createOrder(Long driverTripId, Long passengerTripId);

    @Transactional
    void doCreateOrder(Trip driverTrip, TripCarDto tripCar, Trip passengerTrip, TripPassengerDto tripPassengerDto);

    TripDriverOrder getDriverOrderByTripId(Long tripId);

    void createDriverOrder(TripDriverOrderDto tripDriverOrderDto);
}
