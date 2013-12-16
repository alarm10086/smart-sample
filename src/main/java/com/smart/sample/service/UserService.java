package com.smart.sample.service;

import com.smart.sample.entity.User;

public interface UserService {

    User login(String username, String password);
}
