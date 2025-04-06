package com.mailauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthenticatorPage extends BasePage {

    @FindBy(xpath = "//a[@data-target='#auth_ac']")
    private WebElement add2FAButton;

    @FindBy(xpath = "//input[@id='auth_id']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@id='auth_desc']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@id='auth_code']")
    private WebElement codeInput;

    @FindBy(xpath = "//button[contains(text(), '+Add Generator')]")
    private WebElement confirmAddInput;

    @FindBy(xpath = "//button[@data-target='#auth_del_ac']")
    private WebElement removeAuthButton;

    @FindBy(xpath = "//button[@class='btn']")
    private WebElement removeAuthConfirmationButton;

    @FindBy(xpath = "//div[contains(text(), 'Enable 2-Factor Authentication')]")
    private WebElement emptyAuthListLabel;

    public AuthenticatorPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public AuthenticatorPage addNewAuthenticator(String name, String description, String code) { 
        maximazeWindow();
        return openAdd2FA()
            .enterName(name)
            .enterDescription(description)
            .enterCode(code)
            .confirmAdd();
    }

    private AuthenticatorPage openAdd2FA() {
        getWaiter().until(ExpectedConditions.visibilityOf(add2FAButton));
        add2FAButton.click();
        return this;
    }

    private AuthenticatorPage enterName(String name) {
        getWaiter().until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(name);
        return this;
    }

    private AuthenticatorPage enterDescription(String description) {
        getWaiter().until(ExpectedConditions.visibilityOf(descriptionInput));
        descriptionInput.sendKeys(description);
        return this;
    }

    private AuthenticatorPage enterCode(String code) {
        getWaiter().until(ExpectedConditions.visibilityOf(codeInput));
        codeInput.sendKeys(code);
        return this;
    }

    private AuthenticatorPage confirmAdd() {
        getWaiter().until(ExpectedConditions.visibilityOf(confirmAddInput));
        confirmAddInput.click();
        return this;
    }

    public Boolean is2FAAdded(String name){
        try {
            getWaiter().until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//td[contains(text(), '" + name + "')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AuthenticatorPage removeAuthConfig() {
        getWaiter().until(ExpectedConditions.visibilityOf(removeAuthButton));
        removeAuthButton.click();

        getWaiter().until(ExpectedConditions.visibilityOf(removeAuthConfirmationButton));
        removeAuthConfirmationButton.click();
        
        getWaiter().until(ExpectedConditions.visibilityOf(emptyAuthListLabel));
        return this;
    }
}
