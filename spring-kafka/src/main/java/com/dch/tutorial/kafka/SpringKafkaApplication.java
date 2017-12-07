package com.dch.tutorial.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application of Spring with Kafka Client and used to start application.
 * 
 * @author David.Christianto
 */
@SpringBootApplication
public class SpringKafkaApplication {

	/**
	 * Main method to start application.
	 * 
	 * @param args
	 *            arguments.
	 */
	public static void main(String... args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}
}
