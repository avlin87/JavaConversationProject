package com.testbase;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.UUID;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";

        // Add Chrome options
        Configuration.browserCapabilities.setCapability(
                "goog:chromeOptions",
                new org.openqa.selenium.chrome.ChromeOptions()
                        .addArguments(Arrays.asList(
                                "--no-sandbox",
                                "--disable-dev-shm-usage",
                                "--disable-gpu",
                                "--window-size=1920,1080",
                                "--headless=new",
                                "--user-data-dir=/tmp/chrome-profile-" + UUID.randomUUID()
                        ))
        );
    }
}
