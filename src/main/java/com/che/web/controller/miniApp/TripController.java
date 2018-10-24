package com.che.web.controller.miniApp;

import com.che.dto.TripDto;
import com.che.service.RouteService;
import com.che.service.TripService;
import org.apache.commons.lang3.time.DateUtils;
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
    public Object add(Long userId, Long routeId, String departureTime) throws Exception {

        Long departureTimeInMillis = DateUtils.parseDate(departureTime, "yyyy-MM-dd HH:mm:ss").getTime();
        TripDto tripDto = tripService.createTrip(userId, routeId, departureTimeInMillis);
        return tripDto;
    }
}
