package com.che.dao;

import com.che.model.Station;

public interface StationDao {
    int deleteByPrimaryKey(Integer stationId);

    int insert(Station record);

    Station selectByStationId(Long stationId);

    int updateByPrimaryKeySelective(Station record);
}