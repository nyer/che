package com.che.web.controller.miniApp;

import com.che.service.OrderService;
import com.che.service.TripOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Resource
    private TripOrderService tripOrderService;

    @Resource
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/create")
    public Object create(Long driverTripId, Long passengerTripId) {

        tripOrderService.createOrder(driverTripId, passengerTripId);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/payed")
    public Object payed(Long orderId) {

        orderService.payOrder(orderId);
        return "OK";
    }
}
