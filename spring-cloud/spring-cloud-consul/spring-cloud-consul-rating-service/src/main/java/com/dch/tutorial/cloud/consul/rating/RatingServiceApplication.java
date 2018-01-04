package com.dch.tutorial.cloud.consul.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application of Rating service and used to start application.
 *
 * @author David.Christianto
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RatingServiceApplication {

    /**
     * Main method to start application.
     *
     * @param args arguments.
     */
    public static void main(String... args) {
        SpringApplication.run(RatingServiceApplication.class, args);
    }
}
