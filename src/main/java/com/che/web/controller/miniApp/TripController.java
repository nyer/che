package com.che.web.controller.miniApp;

import com.che.dto.TripCarDto;
import com.che.dto.TripDto;
import com.che.dto.TripPassengerDto;
import com.che.service.TripService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RequestMapping("/trip")
@Controller
public class TripController {

    @Resource
    private TripService tripService;

    @ResponseBody
    @RequestMapping("/addByRoute")
    public Object addByRoute(Long userId, Long routeId, Integer passengerCount, BigDecimal moneyAmount, String phone, String departureTime) throws Exception {

        Long departureTimeInMillis = DateUtils.parseDate(departureTime, "yyyy-MM-dd HH:mm").getTime();
        TripDto trip = new TripDto();
        trip.setUserId(userId);
        trip.setDepartureTime(departureTimeInMillis);

        TripPassengerDto tripPassengerDto = new TripPassengerDto();
        tripPassengerDto.setPassengerCount(passengerCount);
        tripPassengerDto.setMoneyAmount(moneyAmount);
        tripPassengerDto.setPhone(phone);
        trip.setTripPassengerDto(tripPassengerDto);

        tripService.createPassengerTripByRoute(routeId, trip);
        return trip;
    }

    @ResponseBody
    @RequestMapping("/driver/addByRoute")
    public Object addDriverTipByRoute(Long userId, Long routeId, Integer seatCount, String phone, Integer carSource, String carLicense, String departureTime) throws Exception {

        Long departureTimeInMillis = DateUtils.parseDate(departureTime, "yyyy-MM-dd HH:mm").getTime();

        TripDto trip = new TripDto();
        trip.setUserId(userId);
        trip.setDepartureTime(departureTimeInMillis);

        TripCarDto tripCarDto = new TripCarDto();
        tripCarDto.setSpareSeatCount(seatCount);
        tripCarDto.setPhone(phone);
        tripCarDto.setCarLicense(carLicense);
        tripCarDto.setCarSource(carSource);
        trip.setTripCarDto(tripCarDto);

        tripService.createDriverTripByRoute(routeId, trip);

        return trip;
    }
}
