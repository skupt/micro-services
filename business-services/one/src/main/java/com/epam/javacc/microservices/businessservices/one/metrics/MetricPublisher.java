package com.epam.javacc.microservices.businessservices.one.metrics;

import com.netflix.servo.publish.BasicMetricFilter;
import com.netflix.servo.publish.MonitorRegistryMetricPoller;
import com.netflix.servo.publish.PollRunnable;
import com.netflix.servo.publish.PollScheduler;
import com.netflix.servo.publish.atlas.AtlasMetricObserver;
import com.netflix.servo.publish.atlas.BasicAtlasConfig;
import com.netflix.servo.publish.atlas.ServoAtlasConfig;
import com.netflix.servo.tag.BasicTagList;
import com.netflix.servo.tag.TagList;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class MetricPublisher {
    @PostConstruct
    private void init() {
        System.setProperty("servo.pollers", "1000");
        System.setProperty("servo.atlas.batchSize", "1");
        System.setProperty("servo.atlas.uri", "http://localhost:7101/api/v1/publish");
        ServoAtlasConfig config = new BasicAtlasConfig();
        TagList commonTags = BasicTagList.of("servo", "counter", "servo", "one_counter_01", "servo", "one_timer_01");
        AtlasMetricObserver observer = new AtlasMetricObserver(config, commonTags);
        PollRunnable pollRunnable = new PollRunnable(new MonitorRegistryMetricPoller(),
                new BasicMetricFilter(true), observer);
        PollScheduler.getInstance().start();
        PollScheduler.getInstance().addPoller(pollRunnable, 1, SECONDS);
    }
}
