package com.che.service;

import com.che.model.User;

public interface UserService {
    User addUser(User user);

    User getByUserId(Long userId);
}
