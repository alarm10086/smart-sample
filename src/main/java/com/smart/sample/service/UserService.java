package com.smart.sample.service;

import com.smart.plugin.hessian.Hessian;
import com.smart.sample.entity.User;

@Hessian("/user_service")
public interface UserService {

    User login(String username, String password);
}
