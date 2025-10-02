package com.epam.springtest.config;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    @Before(order = 0)
    public void setUp() {
        Configuration.browser = "chrome";

        boolean isCI = "true".equals(System.getenv("GITHUB_ACTIONS"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        options.setCapability("acceptInsecureCerts", true);

        if (isCI) {
            Configuration.headless = true;
            Configuration.browser = "chrome";
            Configuration.browserCapabilities = options;
        } else {
            Configuration.headless = false;
        }
    }
}
