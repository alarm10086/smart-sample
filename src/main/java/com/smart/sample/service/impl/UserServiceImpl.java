package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Service;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {
        return DataSet.select(User.class, "username = ? and password = ?", username, password);
    }
}
