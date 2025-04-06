package com.mailauto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        PageFactory.initElements(getDriver(), this);
    }

    public String getPrivateTeamInbox() {
        return privateTeamInbox.getText();
    }

    public String getUserEmail() {
        getWaiter().until(ExpectedConditions.visibilityOf(userEmail));
        return userEmail.getText();
    }

    public MessageRulesPage openMessageRules() {
        getWaiter().until(ExpectedConditions.visibilityOf(messageRulesLink));
        messageRulesLink.click();
        return new MessageRulesPage();
    }

    public AuthenticatorPage openAuthenticator() {
        getWaiter().until(ExpectedConditions.visibilityOf(authenticatorLink));
        authenticatorLink.click();
        return new AuthenticatorPage();
    }

    public TeamSettingsPage openTeamSettings() {
        getWaiter().until(ExpectedConditions.visibilityOf(teamSettingsLink));
        teamSettingsLink.click();
        return new TeamSettingsPage();
    }
}
