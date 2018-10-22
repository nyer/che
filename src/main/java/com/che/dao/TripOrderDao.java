package com.che.dao;

import com.che.model.TripOrder;

public interface TripOrderDao {
    int deleteByPrimaryKey(Long orderId);

    int insert(TripOrder record);

    int insertSelective(TripOrder record);

    TripOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(TripOrder record);

    int updateByPrimaryKey(TripOrder record);
}