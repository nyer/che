package com.che.service.impl;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.che.dao.StationDao;
import com.che.dto.StationDto;
import com.che.model.Station;
import com.che.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StationServiceImpl implements StationService {

    @Resource
    private StationDao stationDao;

    @Override
    public void addStation(StationDto stationDto) {

        Long current = System.currentTimeMillis();
        Station station = new Station();
        station.setStationName(stationDto.getStationName());
        station.setLatitude(stationDto.getLatitude());
        station.setLongitude(stationDto.getLongitude());
        station.setCreateTime(current);
        station.setUpdateTime(current);

        this.stationDao.insert(station);

        stationDto.setStationId(station.getStationId());
    }

    @Override
    public StationDto getStation(Long stationId) {

        Station station = this.stationDao.selectByStationId(stationId);

        if (station == null) {

            return null;
        }

        StationDto stationDto = new StationDto();
        stationDto.setStationId(station.getStationId());
        stationDto.setStationName(station.getStationName());
        stationDto.setLatitude(station.getLatitude());
        stationDto.setLongitude(station.getLongitude());

        return stationDto;
    }
}
