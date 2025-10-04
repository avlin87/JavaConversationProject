package com.testbase;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.UUID;

public class TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";

        String randomUUIDvalue = UUID.randomUUID().toString();

        log.info("randomUUIDvalue: {}", randomUUIDvalue);

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
