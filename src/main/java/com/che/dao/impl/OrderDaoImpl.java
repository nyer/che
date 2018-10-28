package com.che.dao.impl;

import com.che.dao.OrderDao;
import com.che.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

    @Override
    public int insert(Order record) {
        return insert("OrderMapper.insert", record);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return 0;
    }
}
