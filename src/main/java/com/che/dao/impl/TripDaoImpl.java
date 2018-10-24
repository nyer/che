package com.che.dao.impl;

import com.che.dao.TripDao;
import com.che.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripDaoImpl extends BaseDaoImpl implements TripDao {

    @Override
    public int deleteByPrimaryKey(Long tripId) {
        return 0;
    }

    @Override
    public int insert(Trip record) {
        return insert("TripMapper.insert", record);
    }

    @Override
    public int updateByPrimaryKeySelective(Trip record) {
        return update("TripMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateOrderId(Long tripId, Long orderId) {

        Trip trip = new Trip();
        trip.setTripId(tripId);
        trip.setOrderId(orderId);
        return this.updateByPrimaryKeySelective(trip);
    }
}
