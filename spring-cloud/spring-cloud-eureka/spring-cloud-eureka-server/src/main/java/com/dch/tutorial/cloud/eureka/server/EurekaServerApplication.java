package com.dch.tutorial.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Main application of Eureka Server and used to start application.
 * 
 * @author David.Christianto
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	/**
	 * Main method to start application.
	 * 
	 * @param args
	 *            arguments.
	 */
	public static void main(String... args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
