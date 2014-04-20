package org.smart4j.sample.service.impl;

import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.sample.service.UserService;
import org.smart4j.security.SmartSecurityHelper;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        SmartSecurityHelper.login(username, password, false);
    }
}
