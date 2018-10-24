package com.che.service.impl;

import com.che.constant.OrderStatus;
import com.che.constant.TripType;
import com.che.dao.TripGorderDao;
import com.che.dao.TripOrderDao;
import com.che.dto.TripDto;
import com.che.dto.TripOrderDto;
import com.che.model.TripGorder;
import com.che.model.TripOrder;
import com.che.service.OrderService;
import com.che.service.bean.BeanSelfAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private OrderService self;

    @Override
    public TripGorder createGorder(Long userId, List<TripOrder> orders) {

        Long current = System.currentTimeMillis();
        TripGorder gorder = new TripGorder();
        gorder.setGorderUserId(userId);
        gorder.setOrders(orders);
        gorder.setCreateTime(current);
        gorder.setUpdateTime(current);

        self.doCreateGorder(gorder);
        return gorder;
    }

    @Transactional
    @Override
    public void doCreateGorder(TripGorder gorder) {

        this.tripGorderDao.insert(gorder);

        for (TripOrder order : gorder.getOrders()) {

            order.setGorderId(gorder.getGorderId());
            TripOrder temp = new TripOrder();
            temp.setOrderId(order.getOrderId());
            temp.setGorderId(gorder.getGorderId());
            temp.setUpdateTime(gorder.getUpdateTime());

            this.tripOrderDao.updateByPrimaryKeySelective(temp);
        }
    }

    @Override
    public void createOrder(TripOrderDto tripOrderDto) {

        Long current = System.currentTimeMillis();
        TripOrder order = new TripOrder();
        order.setUserId(tripOrderDto.getUserId());
        order.setTripId(tripOrderDto.getTripDto().getTripId());
        order.setStatus(OrderStatus.WAITING_CAR.getStatus());
        order.setCreateTime(current);
        order.setUpdateTime(current);

        this.tripOrderDao.insert(order);

        tripOrderDto.setOrderId(order.getOrderId());
    }

    @Override
    public void setSelf(Object proxyBean) {

        this.self = (OrderService) proxyBean;
    }
}
