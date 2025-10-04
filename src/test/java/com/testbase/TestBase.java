package com.testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;
import java.nio.file.Path;

public class TestBase {

    static {
        Configuration.browser = "chrome";
        Configuration.headless = true; // run headless in CI
        Configuration.browserSize = "1366x768";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        try {
            // create unique tmp dir per run
            Path tmpProfile = Files.createTempDirectory("chrome-profile");
            options.addArguments("--user-data-dir=" + tmpProfile.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }
}
