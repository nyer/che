package com.che.dao;

import com.che.model.Order;

public interface OrderDao {

    int insert(Order record);

    int updateByPrimaryKeySelective(Order record);
}