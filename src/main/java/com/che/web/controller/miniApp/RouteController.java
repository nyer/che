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
    public Object addRoute(Route route) {

        routeService.addRoute(route);

        return route;
    }
}
