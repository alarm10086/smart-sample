package com.smart.sample.service.impl;

import com.smart.framework.annotation.Service;
import com.smart.sample.service.UserService;
import com.smart.security.SmartSecurityHelper;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        SmartSecurityHelper.login(username, password, false);
    }
}
