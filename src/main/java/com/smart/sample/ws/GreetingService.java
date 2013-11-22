package com.smart.sample.ws;

import com.smart.plugin.ws.annotation.WebService;

@WebService
public interface GreetingService {

    void sayHello(String name);
}
