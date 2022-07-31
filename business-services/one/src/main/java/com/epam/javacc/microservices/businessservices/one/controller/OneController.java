package com.epam.javacc.microservices.businessservices.one.controller;

import com.netflix.discovery.EurekaClient;
import com.netflix.servo.DefaultMonitorRegistry;
import com.netflix.servo.monitor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

@RestController
public class OneController implements GreetingController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;
    @Value("${spring.application.name}")
    private String appName;
    private Counter counter;
    private Timer timer;

    @PostConstruct
    public void init() {
        counter = new BasicCounter(MonitorConfig.builder("counter").build());
        timer = new BasicTimer(MonitorConfig.builder("timer").build(), SECONDS);
        DefaultMonitorRegistry.getInstance().register(counter);
        DefaultMonitorRegistry.getInstance().register(timer);
    }

    @Override
    public String greeting() {
        counter.increment();
        long start = System.nanoTime();
        String greeting = String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
        timer.record(System.nanoTime() - start, TimeUnit.NANOSECONDS);
        return greeting;
    }
}
