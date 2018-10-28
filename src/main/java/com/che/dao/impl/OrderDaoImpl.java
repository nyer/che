package com.che.dao.impl;

import com.che.dao.OrderDao;
import com.che.model.Order;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

    @Override
    public int updateOrderStatus(Long orderId, Integer fromStatus, Integer toStatus) {

        Map<String, Object> cond = Maps.newHashMap();
        cond.put("orderId", orderId);
        cond.put("fromStatus", fromStatus);
        cond.put("toStatus", toStatus);

        return update("OrderMapper.updateOrderStatus", cond);
    }

    List<Order> selectByCond(Map<String, Object> cond) {

        return selectList("OrderMapper.selectByCond", cond);
    }

    @Override
    public Order selectByOrderId(Long orderId) {

        return one(selectByCond(newCond("orderId", orderId)));
    }
}
