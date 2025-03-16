package com.mailauto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h5[contains(text(), 'Private Team Inbox')]")
    private WebElement privateTeamInbox;

    @FindBy(xpath = "//a[@aria-label='User Email']")
    private WebElement userEmail;

    @FindBy(xpath = "//a[contains(text(), 'Message Rules')]")
    private WebElement messageRulesLink;

    @FindBy(xpath = "//a[contains(@href, 'authenticator')]")
    private WebElement authenticatorLink;

    @FindBy(xpath = "//a[contains(@href, 'team_settings')]")
    private WebElement teamSettingsLink;

    public MainPage() {
        wait = new WebDriverWait(getDriver(), 10);
        PageFactory.initElements(getDriver(), this);
    }

    public String getPrivateTeamInbox() {
        return privateTeamInbox.getText();
    }

    public String getUserEmail() {
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        return userEmail.getText();
    }

    public MessageRulesPage openMessageRules() {
        wait.until(ExpectedConditions.visibilityOf(messageRulesLink));
        messageRulesLink.click();
        return new MessageRulesPage();
    }

    public AuthenticatorPage openAuthenticator() {
        wait.until(ExpectedConditions.visibilityOf(authenticatorLink));
        authenticatorLink.click();
        return new AuthenticatorPage();
    }

    public TeamSettingsPage openTeamSettings() {
        wait.until(ExpectedConditions.visibilityOf(teamSettingsLink));
        teamSettingsLink.click();
        return new TeamSettingsPage();
    }
}
