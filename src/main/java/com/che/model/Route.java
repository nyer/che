package com.che.model;

public class Route {
    private Long routeId;

    private String routeName;

    private Long tripTemplateId;

    private Integer initStation;

    private Integer finalStation;

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

    public Integer getInitStation() {
        return initStation;
    }

    public void setInitStation(Integer initStation) {
        this.initStation = initStation;
    }

    public Integer getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(Integer finalStation) {
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