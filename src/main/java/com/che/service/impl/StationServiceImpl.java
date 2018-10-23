package com.che.service.impl;

import com.che.dao.StationDao;
import com.che.model.Station;
import com.che.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StationServiceImpl implements StationService {

    @Resource
    private StationDao stationDao;

    @Override
    public void addStation(Station station) {

        this.stationDao.insert(station);
    }
}
