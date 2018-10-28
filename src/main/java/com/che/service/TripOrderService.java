package com.che.service;

import com.che.dto.TripCarDto;
import com.che.dto.TripOrderDto;
import com.che.dto.TripPassengerDto;
import com.che.model.Trip;
import com.che.model.TripOrder;
import org.springframework.transaction.annotation.Transactional;

public interface TripOrderService {

    /**
     * 到达乘客接送点
     * @param orderId
     */
    @Transactional
    void departureStationArrived(Long orderId);

    /**
     * 乘客已上车
     * @param orderId
     */
    @Transactional
    void passengerOnBoard(Long orderId);

    /**
     * 乘客到达目的地
     * @param orderId
     */
    @Transactional
    void destStationArrived(Long orderId);

    /**
     * 取消订单
     *
     * 只有乘客未上车才可取消订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);

    void createOrder(Long driverTripId, Long passengerTripId);

    @Transactional
    void doCreateOrder(Trip driverTrip, TripCarDto tripCar, Trip passengerTrip, TripPassengerDto tripPassengerDto);

    TripOrder getDriverOrderByTripId(Long tripId);

    void createDriverOrder(TripOrderDto tripDriverOrderDto);
}
