package com.che.service.impl;

import com.che.dao.TripDao;
import com.che.service.TripService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TripServiceImpl implements TripService {

    @Resource
    private TripDao tripDao;
}
