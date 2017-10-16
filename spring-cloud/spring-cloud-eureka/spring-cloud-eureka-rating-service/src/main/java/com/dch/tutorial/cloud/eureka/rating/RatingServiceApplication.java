package com.dch.tutorial.cloud.eureka.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main application of Rating service and used to start application.
 * 
 * @author David.Christianto
 */
@SpringBootApplication
@EnableEurekaClient
public class RatingServiceApplication {

	/**
	 * Main method to start application.
	 * 
	 * @param args
	 *            arguments.
	 */
	public static void main(String... args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}
}
