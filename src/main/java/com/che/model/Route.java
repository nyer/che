package com.che.model;

public class Route {
    private Long routeId;

    private String routeName;

    private Long tripTemplateId;

    private Long initStation;

    private Long finalStation;

    private Long createTime;

    private Long updateTime;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    public Long getTripTemplateId() {
        return tripTemplateId;
    }

    public void setTripTemplateId(Long tripTemplateId) {
        this.tripTemplateId = tripTemplateId;
    }

    public Long getInitStation() {
        return initStation;
    }

    public void setInitStation(Long initStation) {
        this.initStation = initStation;
    }

    public Long getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(Long finalStation) {
        this.finalStation = finalStation;
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