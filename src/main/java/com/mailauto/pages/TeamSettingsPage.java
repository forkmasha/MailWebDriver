package com.mailauto.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamSettingsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'wrapper-primary-input')]/p")
    private WebElement teamNameLabel;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(), 'Set Team Name')]")
    private WebElement setNameButton;

    @FindBy(xpath = "//input[@id='new-teamname-field']")
    private WebElement teamNameInput;

    public TeamSettingsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public TeamSettingsPage setTeamName(String teamName) {
        clickSetNameButton();
        setTeamNameInput(teamName);
        saveButton.click();
        return this;
    }

    private void setTeamNameInput(String teamName) {
        getWaiter().until(ExpectedConditions.visibilityOf(teamNameInput));
        teamNameInput.sendKeys(teamName);
    }

    private void clickSetNameButton() {
        int retries = 3;
        while (retries > 0) {
            try {
                getWaiter().until(ExpectedConditions.elementToBeClickable(setNameButton));
                setNameButton.click();
                return;
            } catch (StaleElementReferenceException e) {
                retries--;
            }
        }
        throw new StaleElementReferenceException("Element is not clickable");
    }

    public String getTeamName() {
        getWaiter().until(ExpectedConditions.visibilityOf(teamNameLabel));
        return teamNameLabel.getText();
    }
}
