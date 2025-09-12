package com.epam.springtest.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test configuration for integrating Cucumber with Spring Boot.
 *
 * <p>Marks this class as the bridge so Cucumber can load the Spring context before executing step
 * definitions.
 */
@CucumberContextConfiguration
@SpringBootTest
public class CucumberSpringConfig {}
