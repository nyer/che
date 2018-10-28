package com.che.dto;

public class TripDto {

    private Long tripId;

    private Integer tripType;

    private Long departureTime;

    private TripCarDto tripCarDto;

    private TripPassengerDto tripPassengerDto;

    private RouteDto routeDto;

    private Long userId;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Integer getTripType() {
        return tripType;
    }

    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    public Long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Long departureTime) {
        this.departureTime = departureTime;
    }

    public TripCarDto getTripCarDto() {
        return tripCarDto;
    }

    public void setTripCarDto(TripCarDto tripCarDto) {
        this.tripCarDto = tripCarDto;
    }

    public TripPassengerDto getTripPassengerDto() {
        return tripPassengerDto;
    }

    public void setTripPassengerDto(TripPassengerDto tripPassengerDto) {
        this.tripPassengerDto = tripPassengerDto;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
