package com.epam.javacc.microservices.businessservices.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OneApp {
    public static void main(String[] args) {
        SpringApplication.run(OneApp.class, args);
    }
}
