package com.che.service;

import com.che.dto.StationDto;
import com.che.model.Station;

public interface StationService {

    void addStation(StationDto stationDto);

    StationDto getStation(Long stationId);
}
