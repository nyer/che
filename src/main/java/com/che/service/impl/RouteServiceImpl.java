package com.che.service.impl;

import com.che.dao.RouteDao;
import com.che.service.RouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteDao routeDao;
}
