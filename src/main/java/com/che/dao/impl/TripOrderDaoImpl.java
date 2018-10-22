package com.che.dao.impl;

import com.che.dao.TripOrderDao;
import com.che.model.TripOrder;
import org.springframework.stereotype.Component;

@Component
public class TripOrderDaoImpl extends BaseDaoImpl implements TripOrderDao {
    @Override
    public int deleteByPrimaryKey(Long orderId) {
        return 0;
    }

    @Override
    public int insert(TripOrder record) {
        return 0;
    }

    @Override
    public int insertSelective(TripOrder record) {
        return 0;
    }

    @Override
    public TripOrder selectByPrimaryKey(Long orderId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TripOrder record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TripOrder record) {
        return 0;
    }
}
