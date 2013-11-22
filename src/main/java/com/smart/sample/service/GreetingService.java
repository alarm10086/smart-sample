package com.smart.sample.service;

import com.smart.plugin.ws.annotation.WebService;

@WebService
public interface GreetingService {

    void sayHello(String name);
}
