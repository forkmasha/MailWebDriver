package com.mailauto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static WebDriverFactory instance;
    private WebDriverFactory() { }

    public static synchronized WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }

    public void setDriver() {
        setDriver(BrowserType.Chrome);
    }

    private static void setDriver(BrowserType browser) {
        WebDriver webDriver;
        switch (browser) {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case Edge:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        driver.set(Objects.requireNonNull(webDriver));
    }

    public WebDriver getDriver(){
        return Objects.requireNonNull(driver.get());
    }

    public void closeBrowser() {
        getDriver().close();
        getDriver().quit();
        driver.remove();
    }
}