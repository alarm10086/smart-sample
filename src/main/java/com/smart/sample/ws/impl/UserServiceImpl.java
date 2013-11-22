package com.smart.sample.ws.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.sample.entity.User;
import com.smart.sample.ws.UserService;
import java.util.Map;

@Bean
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public User login(Map<String, Object> fieldMap) {
        String username = String.valueOf(fieldMap.get("username"));
        String password = String.valueOf(fieldMap.get("password"));
        return DataSet.select(User.class, "username = ? and password = ?", username, password);
    }
}
