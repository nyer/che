package com.che.service.impl;

import com.che.constant.TripType;
import com.che.dao.TripCarDao;
import com.che.dao.TripDao;
import com.che.dao.TripPassengerDao;
import com.che.dto.RouteDto;
import com.che.dto.TripCarDto;
import com.che.dto.TripDto;
import com.che.dto.TripPassengerDto;
import com.che.model.Trip;
import com.che.model.TripCar;
import com.che.model.TripPassenger;
import com.che.service.RouteService;
import com.che.service.TripService;
import com.che.service.bean.BeanSelfAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TripServiceImpl implements TripService, BeanSelfAware {

    @Resource
    private TripDao tripDao;

    @Resource
    private TripCarDao tripCarDao;

    @Resource
    private TripPassengerDao tripPassengerDao;

    @Resource
    private RouteService routeService;

    private TripService self;

    @Override
    public List<Trip> getTripList(List<Long> tripIdList) {

        return tripDao.selectByTripIdList(tripIdList);
    }

    @Override
    public int decSeatCount(Long tripId, int count) {

        return tripCarDao.decSeatCount(tripId, count);
    }

    @Override
    public TripPassengerDto getTripPassengerDto(Long tripId) {

        TripPassenger tripPassenger = tripPassengerDao.selectByTripId(tripId);
        if (tripPassenger == null) {

            return null;
        }

        TripPassengerDto tripPassengerDto = new TripPassengerDto();
        tripPassengerDto.setTripId(tripPassenger.getTripId());
        tripPassengerDto.setPassengerCount(tripPassenger.getPassengerCount());
        tripPassengerDto.setPhone(tripPassenger.getPhone());
        tripPassengerDto.setMoneyAmount(tripPassenger.getMoneyAmount());

        return tripPassengerDto;
    }

    @Override
    public TripCarDto getTripCarDto(Long tripId) {

        TripCar tripCar = tripCarDao.selectByTripId(tripId);

        TripCarDto tripCarDto = new TripCarDto();
        tripCarDto.setTripId(tripCar.getTripId());
        tripCarDto.setCarLicense(tripCar.getCarLicense());
        tripCarDto.setPhone(tripCar.getPhone());
        tripCarDto.setSpareSeatCount(tripCar.getSpareSeatCount());
        tripCarDto.setCarSource(tripCar.getCarSource());

        return tripCarDto;
    }


    @Transactional
    @Override
    public void doCreatePassengerTrip(TripDto tripDto) {

        tripDto.setTripType(TripType.PASSENGER.getType());
        this.doCreateTrip(tripDto);

        // 创建行程乘客信息
        TripPassengerDto tripPassengerDto = tripDto.getTripPassengerDto();
        tripPassengerDto.setTripId(tripDto.getTripId());
        this.createTripPassenger(tripPassengerDto);
    }

    private void createTripPassenger(TripPassengerDto tripPassengerDto) {

        long current = System.currentTimeMillis();
        TripPassenger tripPassenger = new TripPassenger();
        tripPassenger.setTripId(tripPassengerDto.getTripId());
        tripPassenger.setPassengerCount(tripPassengerDto.getPassengerCount());
        tripPassenger.setPhone(tripPassengerDto.getPhone());
        tripPassenger.setMoneyAmount(tripPassengerDto.getMoneyAmount());
        tripPassenger.setCreateTime(current);
        tripPassenger.setUpdateTime(current);
        this.tripPassengerDao.insert(tripPassenger);
    }

    private void createTripCar(TripCarDto tripCarDto) {

        long current = System.currentTimeMillis();
        TripCar tripCar = new TripCar();
        tripCar.setTripId(tripCarDto.getTripId());
        tripCar.setCarSource(tripCarDto.getCarSource());
        tripCar.setCarLicense(tripCarDto.getCarLicense());
        tripCar.setSpareSeatCount(tripCarDto.getSpareSeatCount());
        tripCar.setPhone(tripCarDto.getPhone());
        tripCar.setCreateTime(current);
        tripCar.setUpdateTime(current);

        this.tripCarDao.insert(tripCar);
    }

    @Transactional
    @Override
    public void doCreateDriverTrip(TripDto tripDto) {

        tripDto.setTripType(TripType.DRIVER.getType());
        // 创建行程单
        this.doCreateTrip(tripDto);

        // 创建行程车辆信息
        TripCarDto tripCarDto = tripDto.getTripCarDto();
        tripCarDto.setTripId(tripDto.getTripId());
        this.createTripCar(tripCarDto);
    }

    public void doCreateTrip(TripDto tripDto) {

        Long current = System.currentTimeMillis();

        // 创建行程单
        Trip trip = new Trip();
        trip.setUserId(tripDto.getUserId());
        trip.setRouteId(tripDto.getRouteDto().getRouteId());
        trip.setDepartureTime(tripDto.getDepartureTime());
        trip.setTripType(tripDto.getTripType());
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
    public void createDriverTripByRoute(Long routeId, TripDto tripDto) {

        RouteDto route = routeService.getRouteDto(routeId);
        tripDto.setRouteDto(route);

        this.createDriverTrip(tripDto);
    }

    @Override
    public void createPassengerTripByRoute(Long routeId, TripDto tripDto) {

        RouteDto route = routeService.getRouteDto(routeId);
        tripDto.setRouteDto(route);

        this.createPassengerTrip(tripDto);
    }

    @Override
    public void createPassengerTrip(TripDto tripDto) {

        self.doCreatePassengerTrip(tripDto);
    }

    @Override
    public void createDriverTrip(TripDto tripDto) {

        self.doCreateDriverTrip(tripDto);
    }

    @Override
    public void setSelf(Object proxyBean) {

        this.self = (TripService) proxyBean;
    }
}
