package com.epam.javacc.microservices.businessservices.common.controller;

import com.epam.javacc.microservices.businessservices.common.service.EurekaUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaUrlController {

    @Autowired
    private EurekaUrlService eurekaUrlService;

    @GetMapping("/urls/{id}")
    public String findUrlByVirtualHostName(@PathVariable(name = "id") String virtualHostName) {
        return eurekaUrlService.serviceUrl(virtualHostName);
    }
}
