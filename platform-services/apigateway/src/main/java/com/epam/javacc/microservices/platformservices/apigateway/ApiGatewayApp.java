package com.epam.javacc.microservices.platformservices.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ApiGatewayApp {
    @Value("${EUREKA_URI}")
    private String euri;

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApp.class, args);
    }

}
