package com.che.dao;

import com.che.model.Station;

public interface StationDao {
    int deleteByPrimaryKey(Integer stationId);

    int insert(Station record);

    int updateByPrimaryKeySelective(Station record);
}