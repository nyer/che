package com.che.web.controller.miniApp;

import com.che.service.TripOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/trip/order")
@Controller
public class TripOrderController {

    @Resource
    private TripOrderService orderService;

    @ResponseBody
    @RequestMapping("/create")
    public Object create(Long driverTripId, Long passengerTripId) {

        orderService.createOrder(driverTripId, passengerTripId);
        return "OK";
    }
}
