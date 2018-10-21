package com.che.web.controller;

import com.che.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController {

    @Resource
    private HelloService helloService;
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(String name) {

        return helloService.hello(name);
    }
}
