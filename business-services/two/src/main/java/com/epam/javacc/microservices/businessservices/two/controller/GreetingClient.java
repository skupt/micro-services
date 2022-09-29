package com.epam.javacc.microservices.businessservices.two.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("one")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}
