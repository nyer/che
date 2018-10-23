package com.che.service.impl;

import com.che.dao.RouteDao;
import com.che.dao.TripDao;
import com.che.dto.RouteDto;
import com.che.model.Route;
import com.che.model.Trip;
import com.che.service.RouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteDao routeDao;

    @Resource
    private TripDao tripDao;

    @Override
    public void addRoute(Route route) {

        this.routeDao.insert(route);
    }

    @Override
    public RouteDto getRouteDto(Long routeId) {

        Route route = this.routeDao.selectByRouteId(routeId);

        RouteDto routeDto = new RouteDto();
        return routeDto;
    }

    public void addTrip(Trip trip) {

        this.tripDao.insert(trip);
    }
}
