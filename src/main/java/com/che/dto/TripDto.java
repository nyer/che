package com.che.dto;

import com.che.constant.TripType;

public class TripDto {

    private Long tripId;

    private Long departureTime;

    private RouteDto routeDto;

    private Long userId;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Long departureTime) {
        this.departureTime = departureTime;
    }

    public RouteDto getRouteDto() {
        return routeDto;
    }

    public void setRouteDto(RouteDto routeDto) {
        this.routeDto = routeDto;
    }

    public Long getUserId() {
        return userId;
    }
}
