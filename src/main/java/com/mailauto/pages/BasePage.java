package com.mailauto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mailauto.utils.WebDriverFactory;

public abstract class BasePage {

    protected WebDriverWait getWaiter() {
        return WebDriverFactory.getWaiter();
    }

    protected void openBrowser() {
        WebDriverFactory.getDriver();
    }

    protected void maximazeWindow() {
        getDriver().manage().window().maximize();
    }

    protected WebDriver getDriver() {
        return WebDriverFactory.getDriver();
    }

    public void closeBrowser() {
        WebDriverFactory.closeBrowser();
    }
}