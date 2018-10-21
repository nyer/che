package com.che.service.impl;

import com.che.dao.UserDao;
import com.che.model.User;
import com.che.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserSerivceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User addUser(User user) {

        this.userDao.insert(user);
        return user;
    }

    @Override
    public User getByUserId(Long userId) {

        return userDao.selectByUserId(userId);
    }
}
