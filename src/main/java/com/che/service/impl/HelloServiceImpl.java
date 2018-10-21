package com.che.service.impl;

import com.che.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {

        return "hello, " + name;
    }

}

