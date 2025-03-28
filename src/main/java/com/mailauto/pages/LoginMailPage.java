package com.mailauto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMailPage extends BasePage {
    private static final String MAIL_LOGIN_URL = "https://www.mailinator.com/v4/login.jsp";

    @FindBy(xpath = "//input[@type='text']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//a[@class='btn btn-default submit']")
    private WebElement loginButton;

    private WebDriverWait wait;

    public LoginMailPage() {
        openBrowser();
        this.wait = new WebDriverWait(getDriver(), 10);
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage login(String email, String password) {
        open()
                .enterEmail(email)
                .enterPassword(password)
                .submitLoginInput();
        return new MainPage();
    }

    private LoginMailPage open() {
        getDriver().get(MAIL_LOGIN_URL);
        return this;
    }

    private LoginMailPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        return this;
    }

    private LoginMailPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    private MainPage submitLoginInput() {
        loginButton.click();
        return new MainPage();
    }
}
