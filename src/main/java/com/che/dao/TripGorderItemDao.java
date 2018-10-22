package com.che.dao;

import com.che.model.TripGorderItem;

public interface TripGorderItemDao {
    int deleteByPrimaryKey(Long gorderItemId);

    int insert(TripGorderItem record);

    int insertSelective(TripGorderItem record);

    TripGorderItem selectByPrimaryKey(Long gorderItemId);

    int updateByPrimaryKeySelective(TripGorderItem record);

    int updateByPrimaryKey(TripGorderItem record);
}