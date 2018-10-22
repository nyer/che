package com.che.dao.impl;

import com.che.dao.TripGorderDao;
import com.che.model.TripGorder;
import org.springframework.stereotype.Component;

@Component
public class TripGorderDaoImpl extends BaseDaoImpl implements TripGorderDao {
    @Override
    public int deleteByPrimaryKey(Long gorderId) {
        return 0;
    }

    @Override
    public int insert(TripGorder record) {
        return 0;
    }

    @Override
    public int insertSelective(TripGorder record) {
        return 0;
    }

    @Override
    public TripGorder selectByPrimaryKey(Long gorderId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TripGorder record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TripGorder record) {
        return 0;
    }
}
