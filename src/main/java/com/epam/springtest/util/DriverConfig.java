package com.epam.springtest.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Driver configuration bound from external properties using the {@code driver} prefix.
 *
 * <p>These values are populated from {@code application.properties} / {@code application.yml} (or
 * environment variables) at startup and can be injected wherever needed.
 */
@Component
@ConfigurationProperties(prefix = "driver")
@Data
public class DriverConfig {
    private boolean headless;
}
