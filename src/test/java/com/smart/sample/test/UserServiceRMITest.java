package com.smart.sample.test;

import com.smart.sample.entity.User;
import com.smart.sample.rmi.UserService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceRMITest {

    @Test
    public void loginTest() {
        String username = "admin";
        String password = "admin";
        try {
            UserService userService = (UserService) Naming.lookup("rmi://localhost:8888/UserService");
            User user = userService.login(username, password);
            Assert.assertNotNull(user);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}