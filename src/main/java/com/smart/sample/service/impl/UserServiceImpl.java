package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;

@Bean
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public User login(String username, String password) {
        return DataSet.select(User.class, "username = ? and password = ?", username, password);
    }
}
