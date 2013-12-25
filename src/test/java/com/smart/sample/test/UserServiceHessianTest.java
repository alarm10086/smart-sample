package com.smart.sample.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.smart.sample.entity.User;
import com.smart.sample.service.UserService;
import java.net.MalformedURLException;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceHessianTest {

    @Test
    public void loginTest() {
        String username = "admin";
        String password = "admin";
        try {
            String url = "http://localhost:8080/smart-sample/hessian/user_service";
            HessianProxyFactory factory = new HessianProxyFactory();
            UserService userService = (UserService) factory.create(UserService.class, url);
            User user = userService.login(username, password);
            Assert.assertNotNull(user);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}