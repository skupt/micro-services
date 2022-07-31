package com.epam.javacc.microservices.businessservices.one.metrics;

import com.netflix.servo.publish.*;
import com.netflix.servo.publish.graphite.GraphiteMetricObserver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class MetricPublisher {
    @PostConstruct
    private void init() {
        System.setProperty("servo.pollers", "1000");
        String prefix = "one";
        String addr = "localhost:2003";
        MetricObserver observer = new GraphiteMetricObserver(prefix, addr);
        PollRunnable pollRunnable = new PollRunnable(new MonitorRegistryMetricPoller(),
                new BasicMetricFilter(true), observer);
        PollScheduler.getInstance().start();
        PollScheduler.getInstance().addPoller(pollRunnable, 3, SECONDS);
    }
}
