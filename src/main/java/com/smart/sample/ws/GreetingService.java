package com.smart.sample.ws;

import com.smart.plugin.ws.WebService;

@WebService
public interface GreetingService {

    void sayHello(String name);
}
