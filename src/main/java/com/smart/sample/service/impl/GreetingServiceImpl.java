package com.smart.sample.service.impl;

import com.smart.framework.annotation.Bean;
import com.smart.sample.service.GreetingService;

@Bean
public class GreetingServiceImpl implements GreetingService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
