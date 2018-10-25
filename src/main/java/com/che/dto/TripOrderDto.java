package com.che.dto;

public class TripOrderDto {

    private Long orderId;

    private TripDto tripDto;

    private Long driverOrderId;

    private Long userId;

    private Integer status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public TripDto getTripDto() {
        return tripDto;
    }

    public void setTripDto(TripDto tripDto) {
        this.tripDto = tripDto;
    }

    public Long getDriverOrderId() {
        return driverOrderId;
    }

    public void setDriverOrderId(Long driverOrderId) {
        this.driverOrderId = driverOrderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
