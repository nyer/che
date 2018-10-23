package com.che.model;

public class TripOrder {
    private Long orderId;

    private Long routeId;

    private Long tripId;

    private Long gorderId;

    private Long userId;

    private Integer tripType;

    private String initStationName;

    private Float initLatitude;

    private Float initLongitude;

    private String finalStationName;

    private Float finalLatitude;

    private Float finalLongitude;

    private Long boardTime;

    private Integer status;

    private Long createTime;

    private Long updateTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
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

    public Integer getTripType() {
        return tripType;
    }

    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    public String getInitStationName() {
        return initStationName;
    }

    public void setInitStationName(String initStationName) {
        this.initStationName = initStationName == null ? null : initStationName.trim();
    }

    public Float getInitLatitude() {
        return initLatitude;
    }

    public void setInitLatitude(Float initLatitude) {
        this.initLatitude = initLatitude;
    }

    public Float getInitLongitude() {
        return initLongitude;
    }

    public void setInitLongitude(Float initLongitude) {
        this.initLongitude = initLongitude;
    }

    public String getFinalStationName() {
        return finalStationName;
    }

    public void setFinalStationName(String finalStationName) {
        this.finalStationName = finalStationName == null ? null : finalStationName.trim();
    }

    public Float getFinalLatitude() {
        return finalLatitude;
    }

    public void setFinalLatitude(Float finalLatitude) {
        this.finalLatitude = finalLatitude;
    }

    public Float getFinalLongitude() {
        return finalLongitude;
    }

    public void setFinalLongitude(Float finalLongitude) {
        this.finalLongitude = finalLongitude;
    }

    public Long getBoardTime() {
        return boardTime;
    }

    public void setBoardTime(Long boardTime) {
        this.boardTime = boardTime;
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