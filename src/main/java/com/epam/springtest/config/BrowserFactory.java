package com.epam.springtest.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class BrowserFactory {
    private final Dimension defaultDimension = new Dimension(1920, 1080);
    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait waitDriver;

    public void startBrowser() {
        configureDriver(false);
    }

    public void startBrowser(boolean isHeadLess) {
        configureDriver(isHeadLess);
    }

    private void configureDriver(boolean isHeadLess) {
        String os = System.getProperty("os.name").toLowerCase();
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        if (os.contains("mac") || os.contains("win")) {
            driver = new ChromeDriver(getChromeOptions(isHeadLess));
        } else {
            driver = new ChromeDriver(getChromeOptions(true));
        }

        setDimension(defaultDimension);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        setImplicitWait(20);
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private ChromeOptions getChromeOptions(boolean isHeadLess) {
        Map<String, Object> prefs = new HashMap<>();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments(
                "--window-size=1920x1080",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-extensions",
                "--disable-gpu",
                "--remote-allow-origins=*",
                "--incognito",
                "--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());

        if (isHeadLess) {
            chromeOptions.addArguments("--headless");
        }

        return chromeOptions;
    }

    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void setWaitForPageLoad(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void setDimension(Dimension dimension) {
        driver.manage().window().setSize(dimension);
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
