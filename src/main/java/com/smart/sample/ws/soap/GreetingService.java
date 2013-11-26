package com.smart.sample.ws.soap;

import com.smart.plugin.ws.WebService;

@WebService
public interface GreetingService {

    void sayHello(String name);
}
