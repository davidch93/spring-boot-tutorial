package com.dch.tutorial.cloud.consul.gateway.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger configuration that used for enable one documentation embedded on the
 * gateway for all Microservices.
 *
 * @author David.Christianto
 */
@Component
@Primary
@EnableAutoConfiguration
public class SwaggerResourcesProviderSupport implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("book-service", "/book-api/v2/api-docs", "2.0"));
        resources.add(swaggerResource("rating-service", "/rating-api/v2/api-docs", "2.0"));
        return resources;
    }

    /**
     * Method used to add all Microservices API-docs as Swagger resources.
     *
     * @param name     Docs name.
     * @param location API.
     * @param version  Docs version.
     * @return {@link SwaggerResource}
     */
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
