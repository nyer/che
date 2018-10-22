package com.che.service.impl;

import com.che.constant.OrderStatus;
import com.che.dao.TripGorderDao;
import com.che.dao.TripGorderItemDao;
import com.che.dao.TripOrderDao;
import com.che.model.Trip;
import com.che.model.TripGorder;
import com.che.model.TripOrder;
import com.che.service.OrderService;
import com.che.service.bean.BeanSelfAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单Service
 * @author leiting
 */
@Service
public class OrderServiceImpl implements OrderService, BeanSelfAware {

    @Resource
    private TripOrderDao tripOrderDao;

    @Resource
    private TripGorderDao tripGorderDao;

    @Resource
    private TripGorderItemDao tripGorderItemDao;

    private OrderService self;

    @Override
    public TripGorder createGorder(Long userId, List<TripOrder> orders) {

        TripGorder gorder = new TripGorder();
        self.doCreateGorder(gorder);
        return gorder;
    }

    @Override
    public void doCreateGorder(TripGorder gorder) {


    }

    @Override
    public TripOrder createOrder(Long userId, Trip trip) {

        Long current = System.currentTimeMillis();
        TripOrder order = new TripOrder();

        order.setUserId(userId);
        order.setTripId(trip.getTripId());
        order.setStatus(OrderStatus.WAITING_CAR.getStatus());
        order.setCreateTime(current);
        order.setCreateTime(current);

        this.tripOrderDao.insert(order);

        return order;
    }

    @Override
    public void setSelf(Object proxyBean) {

        this.self = (OrderService) proxyBean;
    }
}
