package com.che.dao.impl;

import com.che.dao.UserDao;
import com.che.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return 0;
    }

    @Override
    public User selectByUserId(Long userId) {

        return selectOne("UserMapper.selectByPrimaryKey", userId);
    }

    @Override
    public int insert(User record) {

        return insert("UserMapper.insert", record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }
}
