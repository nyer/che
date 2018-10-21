package com.che.dao;

import com.che.model.TripTemplate;

public interface TripTemplateDao {
    int deleteByPrimaryKey(Long templateId);

    int insert(TripTemplate record);

    int updateByPrimaryKeySelective(TripTemplate record);
}