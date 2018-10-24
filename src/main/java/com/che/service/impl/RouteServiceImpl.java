package com.che.service.impl;

import com.che.dao.RouteDao;
import com.che.dao.TripDao;
import com.che.dto.RouteDto;
import com.che.dto.StationDto;
import com.che.model.Route;
import com.che.model.Trip;
import com.che.service.RouteService;
import com.che.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteDao routeDao;

    @Resource
    private TripDao tripDao;

    @Resource
    private StationService stationService;

    @Override
    public void addRoute(Route route) {

        this.routeDao.insert(route);
    }

    @Override
    public RouteDto getRouteDto(Long routeId) {

        Route route = this.routeDao.selectByRouteId(routeId);

        RouteDto routeDto = new RouteDto();
        routeDto.setRouteId(route.getRouteId());
        routeDto.setRouteName(route.getRouteName());

        StationDto initStation = stationService.getStation(route.getInitStation());
        StationDto finalStation = stationService.getStation(route.getFinalStation());
        routeDto.setInitStation(initStation);
        routeDto.setFinalStation(finalStation);
        
        return routeDto;
    }

    public void addTrip(Trip trip) {

        this.tripDao.insert(trip);
    }
}
