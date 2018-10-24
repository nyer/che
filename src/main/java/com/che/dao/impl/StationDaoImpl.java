package com.che.dao.impl;

import com.che.dao.StationDao;
import com.che.model.Station;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class StationDaoImpl extends BaseDaoImpl implements StationDao {
    @Override
    public int deleteByPrimaryKey(Integer stationId) {
        return 0;
    }

    @Override
    public int insert(Station record) {
        return insert("StationMapper.insert", record);
    }

    @Override
    public Station selectByStationId(Long stationId) {

        return one(selectByCond(newCond("stationId", stationId)));
    }

    public List<Station> selectByCond(Map<String, Object> cond) {

        if (MapUtils.isEmpty(cond)) {

            return Collections.emptyList();
        }
        return selectList("StationMapper.selectByCond", cond);
    }

    @Override
    public int updateByPrimaryKeySelective(Station record) {
        return 0;
    }
}
