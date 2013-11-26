package com.smart.sample.test;

import com.smart.plugin.ws.WSHelper;
import com.smart.sample.entity.User;
import com.smart.sample.ws.soap.UserService;
import java.util.HashMap;
import java.util.Map;

public class UserServiceClient {

    public static void main(String[] args) {
        String wsAddress = "http://localhost:8080/smart-sample/ws/UserService";
        UserService userService = WSHelper.createWebClient(wsAddress, UserService.class);

        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("username", "admin");
        fieldMap.put("password", "admin");
        User user = userService.login(fieldMap);
        System.out.println(user);
    }
}
