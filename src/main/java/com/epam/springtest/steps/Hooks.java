package com.epam.springtest.steps;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.springtest.config.BrowserFactory;
import com.epam.springtest.util.DriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Slf4j
@RequiredArgsConstructor
public class Hooks {

    private final DriverConfig driverConfig;

    @Before
    public void logScenarioStart(Scenario scenario) {
        log.info("\n** Starting scenario: {} **", scenario.getName());
    }

    @Before
    public void setUp() {
        BrowserFactory.startBrowser(driverConfig.isHeadless());
        WebDriverRunner.setWebDriver(BrowserFactory.getDriver());
    }

    @After
    public void logScenarioEnd(Scenario scenario) {
        log.info("\n** Finished scenario: {} **", scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot =
                    ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_image");
        }
        BrowserFactory.closeBrowser();
    }
}
