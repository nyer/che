package com.che.service;

import com.che.dto.TripDto;
import org.springframework.transaction.annotation.Transactional;

public interface TripService {

    @Transactional
    void doCreatePassengerTrip(TripDto tripDto);

    @Transactional
    void doCreateDriverTrip(TripDto tripDto);

    TripDto createDriverTrip(Long userId, Long routeId, Integer passengerCount, Long departureTime);

    TripDto createPassengerTrip(Long userId, Long routeId, Integer passengerCount, Long driverTripId, Long departureTime);
}
