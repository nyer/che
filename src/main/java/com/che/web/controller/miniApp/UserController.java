package com.che.web.controller.miniApp;

import com.che.model.User;
import com.che.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @GetMapping("/get")
    public Object getUser(Long userId) {

        return userService.getByUserId(userId);
    }

    @ResponseBody
    @GetMapping("/add")
    public Object addUser(User user) {

        long current = System.currentTimeMillis();
        user.setCreateTime(current);
        user.setUpdateTime(current);
        return userService.addUser(user);
    }
}
