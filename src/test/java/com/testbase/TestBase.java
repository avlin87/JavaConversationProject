package com.testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    @BeforeAll
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true; // run headless in CI
        Configuration.browserSize = "1366x768";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");

        try {
            // create unique tmp dir per run
            options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }
}
