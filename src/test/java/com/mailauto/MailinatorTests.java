package com.mailauto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import com.mailauto.pages.LoginMailPage;
import com.mailauto.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Execution(ExecutionMode.CONCURRENT)
public class MailinatorTests extends BaseTests {
    private static final Logger logger = LogManager.getLogger(MailinatorTests.class);

    private static String email = "mytestingcompany@gmail.com";
    private static String password = "5U6N4XDtmxzUB6S";
    private MainPage mainPage;

    @BeforeEach
    public void performLoginToMail(TestInfo testInfo) {
        logStartTest(testInfo);
        var loginMailPage = new LoginMailPage();
        mainPage = loginMailPage.login(email, password);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        logEndTest(testInfo);
        if (mainPage != null) {
            mainPage.closeBrowser();
        }
    }

    @Test
    @DisplayName("Login to mail")
    public void loginToMail() {
        var actualEmail = mainPage.getUserEmail();
        assertEquals(email, actualEmail);  
    }

    @Test
    @DisplayName("Add new message rule")
    public void createMailRule() {
        var expectedDesc = "DescriptionTest";
        var messageRulesPage = mainPage.openMessageRules();
        messageRulesPage.addNewMessageRule("RuleTest", expectedDesc, "1", "Condition1");

        assertTrue(messageRulesPage.isRuleAdded(expectedDesc));
        messageRulesPage.removeRule();
    }

    @Test
    @DisplayName("Add 2FA Authenticator")
    public void add2FAAuthenticator() {
        var authName = "Auth1";
        var authPage = mainPage.openAuthenticator();
        authPage.addNewAuthenticator(authName, "Description1", "123456");
        
        assertTrue(authPage.is2FAAdded(authName));
        authPage.removeAuthConfig();
    }

    @Test
    @DisplayName("Change Team Name")
    public void changeTeamName() {
        var expectedTeamName = "Team1";
        var teamPage = mainPage.openTeamSettings();
        var originalTeamName = teamPage.getTeamName();

        teamPage.setTeamName(expectedTeamName);
        var actualTeamName = teamPage.getTeamName();

        assertEquals(expectedTeamName, actualTeamName);
        teamPage.setTeamName(originalTeamName);
    }

    private void logStartTest(TestInfo testInfo) {
        logger.info(String.format("Starting %s", testInfo.getDisplayName()));
    }

    private void logEndTest(TestInfo testInfo) {
        logger.info(String.format("Completed %s", testInfo.getDisplayName()));
    } 
}