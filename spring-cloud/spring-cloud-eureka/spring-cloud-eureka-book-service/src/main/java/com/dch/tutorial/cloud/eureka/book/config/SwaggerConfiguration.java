package com.dch.tutorial.cloud.eureka.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Default Swagger configuration.
 * 
 * @author David.Christianto
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * Bean of {@link Docket} API Swagger.
	 * <p>
	 * The configuration of Swagger mainly centers around the Docket bean.<br/>
	 * 1. {@code select()} method returns an instance of
	 * {@link ApiSelectorBuilder}, which provides a way to control the endpoints
	 * exposed by Swagger.<br/>
	 * 2. Predicates for selection of RequestHandlers can be configured with the
	 * help of {@link RequestHandlerSelectors} and {@link PathSelectors}. Using
	 * {@code any()} for both will make documentation for your entire API
	 * available through Swagger.
	 * </p>
	 * 
	 * @return {@link Docket}
	 */
	@Bean
	public Docket api() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
		// @formatter:on
	}
}
