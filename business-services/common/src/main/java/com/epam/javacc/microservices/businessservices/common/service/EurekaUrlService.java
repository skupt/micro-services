package com.epam.javacc.microservices.businessservices.common.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EurekaUrlService {
    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl(String virtualHostName) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka(virtualHostName, false);
        return instance.getHomePageUrl();
    }
}
