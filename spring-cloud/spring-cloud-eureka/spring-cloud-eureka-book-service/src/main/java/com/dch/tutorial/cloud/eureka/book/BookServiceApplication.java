package com.dch.tutorial.cloud.eureka.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main application of Book service and used to start application.
 * 
 * @author David.Christianto
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class BookServiceApplication {

	/**
	 * Main method to start application.
	 * 
	 * @param args
	 *            arguments.
	 */
	public static void main(String... args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
}
