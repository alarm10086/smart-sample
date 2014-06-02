package org.smart4j.sample.service.impl;

import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.plugin.security.SecurityHelper;
import org.smart4j.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        SecurityHelper.login(username, password, false);
    }
}
