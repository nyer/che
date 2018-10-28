package com.che.dao.impl;

import com.che.dao.TripOrderDao;
import com.che.model.TripOrder;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TripOrderDaoImpl extends BaseDaoImpl implements TripOrderDao {

    @Override
    public int deleteByPrimaryKey(Long orderId) {
        return 0;
    }

    @Override
    public int insert(TripOrder record) {
        return insert("TripOrderMapper.insert", record);
    }

    @Override
    public TripOrder selectByOrderId(Long orderId) {

        return one(selectByCond(newCond("orderId", orderId)));
    }

    @Override
    public TripOrder selectByTripId(Long tripId) {

        return one(selectByCond(newCond("tripId", tripId)));
    }

    public List<TripOrder> selectByCond(Map<String, Object> cond) {

        return selectList("TripOrderMapper.selectByCond", cond);
    }

    @Override
    public int updateByPrimaryKeySelective(TripOrder record) {

        return update("TripOrderMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateOrderStatus(Long orderId, Integer fromStatus, Integer toStatus) {

        Map<String, Object> cond = Maps.newHashMap();
        cond.put("orderId", orderId);
        cond.put("fromStatus", fromStatus);
        cond.put("toStatus", toStatus);

        return update("TripOrderMapper.updateOrderStatus", cond);
    }
}
