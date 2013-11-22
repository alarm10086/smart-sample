package com.smart.sample.ws.impl;

import com.smart.framework.annotation.Bean;
import com.smart.sample.ws.GreetingService;

@Bean
public class GreetingServiceImpl implements GreetingService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
