package com.epam.springtest.steps;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.springtest.config.BrowserFactory;
import com.epam.springtest.util.DriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Slf4j
@RequiredArgsConstructor
public class Hooks {

    private final DriverConfig driverConfig;

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Before
    public void logScenarioStart(Scenario scenario) {
        log.info("\n** Starting scenario: {} **", scenario.getName());
    }

    @Before("@ui")
    public void setUp() {
        BrowserFactory.startBrowser(driverConfig.isHeadless());
        WebDriverRunner.setWebDriver(BrowserFactory.getDriver());
    }

    @After
    public void logScenarioEnd(Scenario scenario) {
        log.info("\n** Finished scenario: {} **", scenario.getName());
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {
        if (BrowserFactory.getDriver() == null) {
            return;
        }

        final byte[] screenshot =
                ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "failed_image");
    }

    @After
    public void tearDownAllureSelenide() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    @AfterAll
    public static void closeBrowser() {
        BrowserFactory.closeBrowser();
    }
}
