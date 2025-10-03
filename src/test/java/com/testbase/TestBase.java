package com.testbase;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void globalSetup() {
        // Use system properties passed from GitHub Actions, default to headless=true
        Configuration.browser = System.getProperty("selenide.browser", "chrome");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("selenide.headless", "true"));
        Configuration.browserSize = System.getProperty("selenide.browserSize", "1920x1080");
        // optional: Configuration.timeout = 8000;
    }
}
