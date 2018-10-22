package com.che.dao;

import com.che.model.TripGorder;

public interface TripGorderDao {
    int deleteByPrimaryKey(Long gorderId);

    int insert(TripGorder record);

    int insertSelective(TripGorder record);

    TripGorder selectByPrimaryKey(Long gorderId);

    int updateByPrimaryKeySelective(TripGorder record);

    int updateByPrimaryKey(TripGorder record);
}