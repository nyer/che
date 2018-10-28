package com.che.service;

import com.che.dto.TripCarDto;
import com.che.dto.TripDto;
import com.che.dto.TripPassengerDto;
import com.che.model.Trip;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface TripService {

    List<Trip> getTripList(List<Long> tripIdList);

    int decSeatCount(Long tripId, int count);

    TripPassengerDto getTripPassengerDto(Long tripId);

    TripCarDto getTripCarDto(Long tripId);

    @Transactional
    void doCreatePassengerTrip(TripDto tripDto);

    @Transactional
    void doCreateDriverTrip(TripDto tripDto);

    void createDriverTrip(TripDto tripDto);

    void createDriverTripByRoute(Long routeId, TripDto tripDto);

    void createPassengerTripByRoute(Long routeId, TripDto tripDto);

    void createPassengerTrip(TripDto tripDto);
}
