package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Service;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;

//@Service
//@WebServlet("/hessian/user_service")
//public class UserServiceImpl extends HessianServlet implements UserService {
//
//    @Override
//    public User login(String username, String password) {
//        return DataSet.select(User.class, "username = ? and password = ?", username, password);
//    }
//}

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {
        return DataSet.select(User.class, "username = ? and password = ?", username, password);
    }
}
