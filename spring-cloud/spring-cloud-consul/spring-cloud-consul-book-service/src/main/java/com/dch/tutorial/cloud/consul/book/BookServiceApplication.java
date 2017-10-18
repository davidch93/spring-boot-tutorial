package com.dch.tutorial.cloud.consul.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application of Book service and used to start application.
 * 
 * @author David.Christianto
 */
@SpringBootApplication
@EnableDiscoveryClient
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
