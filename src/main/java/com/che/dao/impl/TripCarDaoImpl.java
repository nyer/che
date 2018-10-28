package com.che.dao.impl;

import com.che.dao.TripCarDao;
import com.che.model.TripCar;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class TripCarDaoImpl extends BaseDaoImpl implements TripCarDao {
    @Override
    public int insert(TripCar record) {
        return insert("TripCarMapper.insert", record);
    }

    @Override
    public TripCar selectByTripId(Long tripId) {

        return one(selectByCond(newCond("tripId", tripId)));
    }

    @Override
    public int decSeatCount(Long tripId, int decCount) {

        Map<String, Object> cond = Maps.newHashMap();
        cond.put("tripId", tripId);
        cond.put("decCount", decCount);
        return update("TripCarMapper.decSeatCount", cond);
    }

    List<TripCar> selectByCond(Map<String, Object> cond) {

        if (MapUtils.isEmpty(cond)) {

            return Collections.emptyList();
        }

        return selectList("TripCarMapper.selectByCond", cond);
    }
    @Override
    public int updateByPrimaryKeySelective(TripCar record) {
        return 0;
    }
}
