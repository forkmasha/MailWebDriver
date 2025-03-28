package com.mailauto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mailauto.utils.WebDriverFactory;

public abstract class BasePage {

    protected WebDriverWait wait;

    protected void openBrowser() {
        WebDriverFactory.getInstance().setDriver();
    }

    protected void maximazeWindow() {
        getDriver().manage().window().maximize();
    }

    protected WebDriver getDriver() {
        return WebDriverFactory.getInstance().getDriver();
    }

    public void closeBrowser() {
        WebDriverFactory.getInstance().closeBrowser();
    }
}