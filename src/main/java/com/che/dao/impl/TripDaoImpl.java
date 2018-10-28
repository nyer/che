package com.che.dao.impl;

import com.che.dao.TripDao;
import com.che.model.Trip;
import com.che.model.TripCar;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Trip> selectByTripIdList(List<Long> tripIdList) {
        return selectByCond(newCond("tripIdList", tripIdList));
    }

    List<Trip> selectByCond(Map<String, Object> cond) {

        if (MapUtils.isEmpty(cond)) {

            return Collections.emptyList();
        }

        return selectList("TripMapper.selectByCond", cond);
    }
}
