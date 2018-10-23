package com.che.service;

import com.che.dto.RouteDto;
import com.che.model.Route;
import com.che.model.Station;

public interface RouteService {

    void addRoute(Route route);

    RouteDto getRouteDto(Long routeId);
}
