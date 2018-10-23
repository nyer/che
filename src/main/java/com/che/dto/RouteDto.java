package com.che.dto;

public class RouteDto {

    private Long routeId;

    private String routeName;

    private StationDto initStation;

    private StationDto finalStation;

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
        this.routeName = routeName;
    }

    public StationDto getInitStation() {
        return initStation;
    }

    public void setInitStation(StationDto initStation) {
        this.initStation = initStation;
    }

    public StationDto getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(StationDto finalStation) {
        this.finalStation = finalStation;
    }
}
