package com.dch.tutorial.cloud.eureka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Main application of Configuration Server and used to start application.
 * 
 * @author David.Christianto
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	/**
	 * Main method to start application.
	 * 
	 * @param args
	 *            arguments.
	 */
	public static void main(String... args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
