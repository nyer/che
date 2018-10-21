package com.che.dao;

import com.che.model.Route;

public interface RouteDao {

    int deleteByPrimaryKey(Long routeId);

    int insert(Route record);

    int updateByPrimaryKeySelective(Route record);
}