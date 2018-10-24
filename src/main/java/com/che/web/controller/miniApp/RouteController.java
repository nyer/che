package com.che.web.controller.miniApp;

import com.che.model.Route;
import com.che.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/route")
@Controller
public class RouteController {

    @Resource
    private RouteService routeService;

    @ResponseBody
    @GetMapping("/add")
    public Object addRoute(String name, Long initStationId, Long finalStationId) {

        long current = System.currentTimeMillis();
        Route route = new Route();
        route.setRouteName(name);
        route.setInitStation(initStationId);
        route.setFinalStation(finalStationId);
        route.setUpdateTime(current);
        route.setCreateTime(current);

        routeService.addRoute(route);

        return route;
    }
    
    @ResponseBody
    @GetMapping("/get")
    public Object get(Long routeId) {

        return routeService.getRouteDto(routeId);
    }
}
