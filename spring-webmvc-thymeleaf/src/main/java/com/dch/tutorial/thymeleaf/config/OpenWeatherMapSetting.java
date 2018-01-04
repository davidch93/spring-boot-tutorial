package com.dch.tutorial.thymeleaf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Class property source that contains parameter setting of open weather map
 * API.
 *
 * @author David.Christianto
 */
@Configuration
@PropertySource("classpath:config/openweathermap/openweathermap-config.properties")
@ConfigurationProperties(prefix = "openweathermap")
public class OpenWeatherMapSetting {

    private String api;
    private String appId;

    /**
     * @return the api
     */
    public String getApi() {
        return api;
    }

    /**
     * @param api the api to set
     */
    public void setApi(String api) {
        this.api = api;
    }

    /**
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId the appId to set
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }
}
