package com.dch.tutorial.cloud.eureka.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Main application of Gateway service using Eureka Server and used to start
 * application.
 *
 * @author David.Christianto
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication {

    /**
     * Main method to start application.
     *
     * @param args arguments.
     */
    public static void main(String... args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
