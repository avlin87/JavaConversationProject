package com.epam.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class.
 *
 * <p>Provides the base configuration and component scanning root for the test framework. Used by
 * {@code @SpringBootTest} during integration and Cucumber test execution.
 */
@SpringBootApplication
public class SpringTestApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringTestApplication.class, args);
  }
}
