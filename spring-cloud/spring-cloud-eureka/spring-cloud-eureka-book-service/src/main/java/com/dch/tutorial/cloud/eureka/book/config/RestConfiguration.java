package com.dch.tutorial.cloud.eureka.book.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Default Hystrix and {@link RestTemplate} configuration.
 *
 * @author David.Christianto
 */
@Configuration
public class RestConfiguration {

    /**
     * Configured {@link LoadBalanced} to use a LoadBalancerClient.
     *
     * @return {@link RestTemplate}
     */
    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
}
