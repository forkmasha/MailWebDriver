package com.mailauto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waiter = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(getBrowserType());
    }

    public static WebDriver getDriver(BrowserType browser) {
        if (driver.get() == null) {
            WebDriver webDriver;
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + browser);
            }
            driver.set(Objects.requireNonNull(webDriver));
        }
        return driver.get();
    }

    public static WebDriverWait getWaiter() {
        if (waiter.get() == null) {
            waiter.set(new WebDriverWait(getDriver(), 10));
        }
        return waiter.get();
    }

    public static void closeBrowser() {
        if (driver.get() != null) {
            getDriver().close();
            getDriver().quit();
            driver.remove();
            waiter.remove();
        }
    }

    private static BrowserType getBrowserType() {
        String browser = System.getProperty("browser", "CHROME");
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        return browserType;
    }
}
