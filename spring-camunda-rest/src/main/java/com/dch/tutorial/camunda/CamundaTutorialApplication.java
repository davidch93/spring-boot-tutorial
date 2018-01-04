package com.dch.tutorial.camunda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application of Camunda Rest and used to start application.
 *
 * @author David.Christianto
 */
@SpringBootApplication
public class CamundaTutorialApplication {

    /**
     * Main method to start application.
     *
     * @param args arguments.
     */
    public static void main(String... args) {
        SpringApplication.run(CamundaTutorialApplication.class, args);
    }
}
