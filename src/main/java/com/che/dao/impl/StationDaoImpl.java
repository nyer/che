package com.che.dao.impl;

import com.che.dao.StationDao;
import com.che.model.Station;
import org.springframework.stereotype.Component;

@Component
public class StationDaoImpl implements StationDao {
    @Override
    public int deleteByPrimaryKey(Integer stationId) {
        return 0;
    }

    @Override
    public int insert(Station record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Station record) {
        return 0;
    }
}
