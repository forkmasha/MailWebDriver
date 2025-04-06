package com.mailauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MessageRulesPage extends BasePage {

    @FindBy(xpath = "//div[@class='wrapper-buttons']/a")
    private WebElement addRuleButton;

    @FindBy(xpath = "//input[@id='rulename']")
    private WebElement ruleNameInput;

    @FindBy(xpath = "//input[@id='ruledesc']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@id='priority']")
    private WebElement priorityInput;

    @FindBy(xpath = "//input[@id='cond1_input']")
    private WebElement conditionInput;

    @FindBy(xpath = "//select[@id='action_sel99']")
    private WebElement actionDropdown;

    @FindBy(xpath = "//button[contains(text(), '+Add Rule')]")
    private WebElement confirmAddInput;

    @FindBy(xpath = "(//button[@data-target='#rule_dm'])[2]")
    private WebElement removeRuleButton;

    @FindBy(xpath = "//button[@class='btn']")
    private WebElement removeRuleConfirmationButton;

    public MessageRulesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MessageRulesPage addNewMessageRule(String ruleName, String description, String priority, String condition) {
        return openCreateRules()
            .enterRuleName(ruleName)
            .enterDescription(description)
            .enterPriority(priority)
            .enterCondition(condition)
            .selectDropAction()
            .confirmAddRule();
    }
    
    private MessageRulesPage openCreateRules() {
        getWaiter().until(ExpectedConditions.visibilityOf(addRuleButton));
        addRuleButton.click();
        return this;
    }

    private MessageRulesPage enterRuleName(String ruleName) {
        getWaiter().until(ExpectedConditions.visibilityOf(ruleNameInput));
        ruleNameInput.sendKeys(ruleName);
        return this;
    }

    private MessageRulesPage enterDescription(String description) {
        descriptionInput.sendKeys(description);
        return this;
    }

    private MessageRulesPage enterPriority(String priority) {
        priorityInput.sendKeys(priority);
        return this;
    }

    private MessageRulesPage enterCondition(String condition) {
        conditionInput.sendKeys(condition);
        return this;
    }

    private MessageRulesPage selectDropAction() {
        getWaiter().until(ExpectedConditions.visibilityOf(actionDropdown));
        Select select = new Select(actionDropdown);
        select.selectByVisibleText("DROP");
        return this;
    }

    public Boolean isRuleAdded(String description){
        try {
            getWaiter().until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(text(), '" + description + "')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public MessageRulesPage removeRule() {
        removeRuleButton.click();
        getWaiter().until(ExpectedConditions.visibilityOf(removeRuleConfirmationButton));
        removeRuleConfirmationButton.click();
        return this;
    }

    private MessageRulesPage confirmAddRule() {
        scrollToElement(confirmAddInput);
        getWaiter().until(ExpectedConditions.elementToBeClickable(confirmAddInput));
        confirmAddInput.click();
        return this;
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
