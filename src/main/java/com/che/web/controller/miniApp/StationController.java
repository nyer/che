package com.che.web.controller.miniApp;

import com.che.dto.StationDto;
import com.che.model.Station;
import com.che.service.StationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/station")
@Controller
public class StationController {

    @Resource
    private StationService stationService;

    @ResponseBody
    @GetMapping("/add")
    public Object addStation(String name, Float lat, Float longt) {

        StationDto station = new StationDto();
        station.setStationName(name);
        station.setLatitude(lat);
        station.setLongitude(longt);
        stationService.addStation(station);

        return station;
    }

    @ResponseBody
    @GetMapping("/get")
    public Object get(long stationId) {

        return stationService.getStation(stationId);
    }
}
