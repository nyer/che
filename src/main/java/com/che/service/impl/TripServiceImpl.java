package com.che.service.impl;

import com.che.constant.TripType;
import com.che.dao.TripDao;
import com.che.dto.RouteDto;
import com.che.dto.TripDriverOrderDto;
import com.che.dto.TripDto;
import com.che.dto.TripOrderDto;
import com.che.model.Trip;
import com.che.model.TripDriverOrder;
import com.che.service.OrderService;
import com.che.service.RouteService;
import com.che.service.TripService;
import com.che.service.bean.BeanSelfAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TripServiceImpl implements TripService, BeanSelfAware {

    @Resource
    private TripDao tripDao;

    @Resource
    private OrderService orderService;

    @Resource
    private RouteService routeService;

    private TripService self;

    @Transactional
    @Override
    public void doCreatePassengerTrip(TripDto tripDto) {

        this.doCreateTrip(tripDto);
        // 创建行程订单
        TripOrderDto tripOrderDto = new TripOrderDto();
        tripOrderDto.setTripDto(tripDto);
        tripOrderDto.setUserId(tripDto.getUserId());

        if (tripDto.getDriverTripId() != null) {

            TripDriverOrder tripDriverOrder = orderService.getDriverOrderByTripId(tripDto.getDriverTripId());
            if (tripDriverOrder != null) {
                tripOrderDto.setDriverOrderId(tripDriverOrder.getOrderId());
            }
        }
        orderService.createPassengerOrder(tripOrderDto);

        tripDto.setOrderId(tripOrderDto.getOrderId());
        tripDao.updateOrderId(tripDto.getTripId(), tripDto.getOrderId());
    }

    @Transactional
    @Override
    public void doCreateDriverTrip(TripDto tripDto) {

        this.doCreateTrip(tripDto);

        // 创建行程订单
        TripDriverOrderDto tripOrderDto = new TripDriverOrderDto();
        tripOrderDto.setTripDto(tripDto);
        tripOrderDto.setUserId(tripDto.getUserId());

        orderService.createDriverOrder(tripOrderDto);

        tripDto.setOrderId(tripOrderDto.getOrderId());
        tripDao.updateOrderId(tripDto.getTripId(), tripDto.getOrderId());
    }

    public void doCreateTrip(TripDto tripDto) {

        Long current = System.currentTimeMillis();

        // 创建行程单
        Trip trip = new Trip();
        trip.setUserId(tripDto.getUserId());
        trip.setRouteId(tripDto.getRouteDto().getRouteId());
        trip.setDepartureTime(tripDto.getDepartureTime());
        trip.setPassengerCount(tripDto.getPassengerCount());

        if (tripDto.getRouteDto().getRouteId() != null) {

            trip.setTripType(TripType.REGULAR_BUS.getType());
        } else {
            trip.setTripType(TripType.FAST_CAR.getType());
        }
        trip.setInitStationName(tripDto.getRouteDto().getInitStation().getStationName());
        trip.setInitLatitude(tripDto.getRouteDto().getInitStation().getLatitude());
        trip.setInitLongitude(tripDto.getRouteDto().getInitStation().getLongitude());
        trip.setFinalStationName(tripDto.getRouteDto().getFinalStation().getStationName());
        trip.setFinalLatitude(tripDto.getRouteDto().getFinalStation().getLatitude());
        trip.setFinalLongitude(tripDto.getRouteDto().getFinalStation().getLongitude());
        trip.setCreateTime(current);
        trip.setUpdateTime(current);

        this.tripDao.insert(trip);
        tripDto.setTripId(trip.getTripId());
    }

    @Override
    public TripDto createPassengerTrip(Long userId, Long routeId, Integer passengerCount, Long driverTripId, Long departureTime) {

        TripDto trip = new TripDto();
        RouteDto route = routeService.getRouteDto(routeId);
        trip.setUserId(userId);
        trip.setDriverTripId(driverTripId);
        trip.setRouteDto(route);
        trip.setDepartureTime(departureTime);
        trip.setPassengerCount(passengerCount);

        self.doCreatePassengerTrip(trip);
        return trip;
    }

    @Override
    public TripDto createDriverTrip(Long userId, Long routeId, Integer passengerCount, Long departureTime) {

        TripDto trip = new TripDto();
        RouteDto route = routeService.getRouteDto(routeId);
        trip.setUserId(userId);
        trip.setRouteDto(route);
        trip.setDepartureTime(departureTime);
        trip.setPassengerCount(passengerCount);

        self.doCreateDriverTrip(trip);
        return trip;
    }

    @Override
    public void setSelf(Object proxyBean) {

        this.self = (TripService) proxyBean;
    }
}
