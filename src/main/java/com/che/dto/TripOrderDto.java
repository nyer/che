package com.che.dto;

public class TripOrderDto {

    private Long orderId;

    private TripDto tripDto;

    private Long gorderId;

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

    public Long getGorderId() {
        return gorderId;
    }

    public void setGorderId(Long gorderId) {
        this.gorderId = gorderId;
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
