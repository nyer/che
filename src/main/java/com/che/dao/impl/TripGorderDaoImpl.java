package com.che.dao.impl;

import com.che.dao.TripGorderDao;
import com.che.model.TripGorder;
import org.springframework.stereotype.Component;

@Component
public class TripGorderDaoImpl extends BaseDaoImpl implements TripGorderDao {
    @Override
    public int insert(TripGorder record) {
        return insert("TripGorderMapper.insert", record);
    }

    public int updateByPrimaryKeySelective(TripGorder record) {
        return update("TripGorderMapper.updateByPrimaryKeySelective", record);
    }
}
