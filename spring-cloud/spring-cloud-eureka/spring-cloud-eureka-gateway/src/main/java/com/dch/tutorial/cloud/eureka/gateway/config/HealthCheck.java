package com.dch.tutorial.cloud.eureka.gateway.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Custom health indicator – which can collect any type of custom health data
 * specific to the application and provide it to the /health endpoint.
 * 
 * @author David.Christianto
 */
@Component
public class HealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		// Perform some specific health check.
		int errorCode = check();
		if (errorCode != 0) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}

	/**
	 * Your logic to check health.
	 */
	public int check() {
		return 0;
	}

}
