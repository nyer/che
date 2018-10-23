package com.che.web.controller.miniApp;

import com.che.dto.RouteDto;
import com.che.dto.TripDto;
import com.che.model.Route;
import com.che.service.RouteService;
import com.che.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/trip")
@Controller
public class TripController {

    @Resource
    private TripService tripService;

    @Resource
    private RouteService routeService;

    @ResponseBody
    @RequestMapping("/add")
    public Object add(Long userId, Long routeId, Long departureTime) {

        TripDto trip = new TripDto();
        RouteDto route = routeService.getRouteDto(routeId);
        tripService.addTrip(trip);
        return trip;
    }
}
