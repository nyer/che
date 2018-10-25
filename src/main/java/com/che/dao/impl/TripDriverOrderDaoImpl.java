package com.che.dao.impl;

import com.che.dao.TripDriverOrderDao;
import com.che.model.Trip;
import com.che.model.TripDriverOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TripDriverOrderDaoImpl extends BaseDaoImpl implements TripDriverOrderDao {

    @Override
    public int deleteByPrimaryKey(Long orderId) {
        return 0;
    }

    @Override
    public int insert(TripDriverOrder record) {
        return insert("TripDriverOrderMapper.insert", record);
    }

    @Override
    public TripDriverOrder selectByOrderId(Long orderId) {

        return one(selectByCond(newCond("orderId", orderId)));
    }

    @Override
    public TripDriverOrder selectByTripId(Long tripId) {

        return one(selectByCond(newCond("tripId", tripId)));
    }

    public List<TripDriverOrder> selectByCond(Map<String, Object> cond) {

        return selectList("TripDriverOrderMapper.selectByCond", cond);
    }

    @Override
    public int updateByPrimaryKeySelective(TripDriverOrder record) {

        return update("TripDriverOrderMapper.updateByPrimaryKeySelective", record);
    }
}
