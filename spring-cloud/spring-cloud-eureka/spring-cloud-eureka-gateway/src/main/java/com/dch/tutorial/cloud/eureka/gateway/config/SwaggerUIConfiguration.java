package com.dch.tutorial.cloud.eureka.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Default Swagger UI configuration. Customized by providing UIConfiguration.
 * 
 * @author David.Christianto
 */
@Configuration
@EnableSwagger2
public class SwaggerUIConfiguration {

	/**
	 * Default operations expansion level by setting “list” as a second
	 * constructor parameter – docExpansion.
	 * 
	 * @return {@link UiConfiguration}
	 */
	@Bean
	public UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	}
}
