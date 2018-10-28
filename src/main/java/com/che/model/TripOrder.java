package com.che.model;

public class TripOrder {
    private Long orderId;

    private Long gorderId;

    private Long passengerOrderId;

    private Long tripId;

    private Long driverTripId;

    private Long userId;

    private Integer status;

    private Long createTime;

    private Long updateTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGorderId() {
        return gorderId;
    }

    public void setGorderId(Long gorderId) {
        this.gorderId = gorderId;
    }

    public Long getPassengerOrderId() {
        return passengerOrderId;
    }

    public void setPassengerOrderId(Long passengerOrderId) {
        this.passengerOrderId = passengerOrderId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getDriverTripId() {
        return driverTripId;
    }

    public void setDriverTripId(Long driverTripId) {
        this.driverTripId = driverTripId;
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}