package com.epam.springtest.config;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeAll;

import java.util.List;
import java.util.Map;

public class Hooks {

    @BeforeAll
    public void setUp() {
        Configuration.browser = "chrome";

        boolean isCI = "true".equals(System.getenv("GITHUB_ACTIONS"));

        if (isCI) {
            Configuration.headless = true;
            Configuration.browserCapabilities.setCapability("chromeOptions", Map.of(
                    "args", List.of(
                            "--no-sandbox",
                            "--disable-dev-shm-usage",
                            "--disable-gpu",
                            "--disable-extensions",
                            "--remote-allow-origins=*",
                            "--user-data-dir=/tmp/chrome-profile"
                    )
            ));
        } else {
            Configuration.headless = false;
        }

        Configuration.baseUrl = "http://localhost:8080"; // o tu baseUrl real
    }
}
