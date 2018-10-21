package com.che.dao;

import com.che.model.User;

public interface UserDao {

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    User selectByUserId(Long userId);

    int updateByPrimaryKeySelective(User record);
}