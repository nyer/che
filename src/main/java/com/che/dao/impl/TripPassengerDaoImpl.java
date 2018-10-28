package com.che.dao.impl;

import com.che.dao.TripPassengerDao;
import com.che.model.TripPassenger;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class TripPassengerDaoImpl extends BaseDaoImpl implements TripPassengerDao {
    @Override
    public int insert(TripPassenger record) {
        return insert("TripPassengerMapper.insert", record);
    }

    @Override
    public TripPassenger selectByTripId(Long tripId) {

        return one(selectByCond(newCond("tripId", tripId)));
    }

    List<TripPassenger> selectByCond(Map<String, Object> cond) {

        if (MapUtils.isEmpty(cond)) {

            return Collections.emptyList();
        }

        return selectList("TripPassengerMapper.selectByCond", cond);
    }

    @Override
    public int updateByPrimaryKeySelective(TripPassenger record) {
        return 0;
    }
}
