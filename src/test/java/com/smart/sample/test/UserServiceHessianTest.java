package com.smart.sample.test;

import com.smart.plugin.hessian.HessianHelper;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceHessianTest {

    @Test
    public void loginTest() throws Exception {
        String username = "admin";
        String password = "admin";

        String url = "http://localhost:8080/smart-sample/hessian/user_service";
        UserService userService = HessianHelper.createClient(url, UserService.class);

        User user = userService.login(username, password);
        Assert.assertNotNull(user);
    }
}