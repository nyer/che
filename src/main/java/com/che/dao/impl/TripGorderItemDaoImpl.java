package com.che.dao.impl;

import com.che.dao.TripGorderItemDao;
import com.che.model.TripGorderItem;
import org.springframework.stereotype.Component;

@Component
public class TripGorderItemDaoImpl extends BaseDaoImpl implements TripGorderItemDao {
    @Override
    public int deleteByPrimaryKey(Long gorderItemId) {
        return 0;
    }

    @Override
    public int insert(TripGorderItem record) {
        return 0;
    }

    @Override
    public int insertSelective(TripGorderItem record) {
        return 0;
    }

    @Override
    public TripGorderItem selectByPrimaryKey(Long gorderItemId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TripGorderItem record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TripGorderItem record) {
        return 0;
    }
}
