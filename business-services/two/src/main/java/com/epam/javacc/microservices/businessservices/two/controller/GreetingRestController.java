package com.epam.javacc.microservices.businessservices.two.controller;

import com.netflix.servo.DefaultMonitorRegistry;
import com.netflix.servo.monitor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import static java.util.concurrent.TimeUnit.SECONDS;

@RestController
public class GreetingRestController {
    @Autowired
    private GreetingClient greetingClient;
    private Counter counter;
    private Timer timer;

    @PostConstruct
    private void init() {
        counter = new BasicCounter(MonitorConfig.builder("two_counter_01").build());
        timer = new BasicTimer(MonitorConfig.builder("two_timer_01").build(), SECONDS);
        DefaultMonitorRegistry.getInstance().register(counter);
        DefaultMonitorRegistry.getInstance().register(timer);
    }

    @RequestMapping("/api/get-greeting")
    public String getGreeting(Model model) {
        counter.increment();
        Stopwatch stopwatch = timer.start();
        String greeting = "TWO says: '" + greetingClient.greeting() + "'";
        stopwatch.stop();
        return greeting;
    }
}
