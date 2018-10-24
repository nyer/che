package com.che.service;

import com.che.dto.TripDto;

public interface TripService {

    void doCreateTrip(TripDto tripDto);

    TripDto createTrip(Long userId, Long routeId, Long departureTime);
}
