package com.che.dao.impl;

import com.che.dao.TripDriverGorderDao;
import com.che.model.TripDriverGorder;
import org.springframework.stereotype.Component;

@Component
public class TripDriverGorderDaoImpl extends BaseDaoImpl implements TripDriverGorderDao {
    @Override
    public int insert(TripDriverGorder record) {
        return insert("TripDriverGorderMapper.insert", record);
    }

    public int updateByPrimaryKeySelective(TripDriverGorder record) {
        return update("TripDriverGorderMapper.updateByPrimaryKeySelective", record);
    }
}
