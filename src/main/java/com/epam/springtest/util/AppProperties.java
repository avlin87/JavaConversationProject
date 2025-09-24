package com.epam.springtest.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Application-level configuration bound from external properties using the {@code app} prefix.
 *
 * <p>These values are populated from {@code application.properties} / {@code application.yml} (or
 * environment variables) at startup and can be injected wherever needed.
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
  private String username;
  private String password;
  private String baseUrl;
  private String browser;
}
