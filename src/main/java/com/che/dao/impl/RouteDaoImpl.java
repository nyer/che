package com.che.dao.impl;

import com.che.dao.RouteDao;
import com.che.model.Route;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class RouteDaoImpl extends BaseDaoImpl implements RouteDao {

    @Override
    public int deleteByPrimaryKey(Long routeId) {
        return 0;
    }

    @Override
    public int insert(Route record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Route record) {
        return 0;
    }

    @Override
    public Route selectByRouteId(Long routeId) {

        return one(selectByCond(newCond("routeId", routeId)));
    }

    public List<Route> selectByCond(Map<String, Object> cond) {

        if (MapUtils.isEmpty(cond)) {

            return Collections.emptyList();
        }

        return selectList("RouteMapper.selectByCond", cond);
    }
}
