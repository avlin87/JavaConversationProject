package com.epam.springtest.config;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import java.util.List;
import java.util.Map;

public class Hooks {

    @Before(order = 0)
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
    }
}
