package com.smart.sample.test;

import com.smart.plugin.ws.helper.WSHelper;
import com.smart.sample.ws.GreetingService;

public class GreetingServiceClient {

    public static void main(String[] args) throws Exception {
        String wsAddress = "http://localhost:8080/smart-sample/ws/GreetingService";
        GreetingService greetingService = WSHelper.createWebClient(wsAddress, GreetingService.class);

        greetingService.sayHello("Jack");
    }
}
