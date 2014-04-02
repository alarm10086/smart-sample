package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Service;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;
import com.smart.security.SmartSecurityHelper;
import com.smart.security.exception.LoginException;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {
        try {
            SmartSecurityHelper.login(username, password, false);
            return DataSet.select(User.class, "username = ?", username);
        } catch (LoginException e) {
            return null;
        }
    }
}
