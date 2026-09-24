package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends CommonToAllPage {

    // =========================
    // Account Created Locators
    // =========================

    private final By accountCreatedMessage =
            By.xpath("//h2[@data-qa='account-created']");

    private final By continueButton =
            By.xpath("//a[@data-qa='continue-button']");


    // =========================
    // Constructor
    // =========================

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }


    // =========================
    // Account Created Verification
    // =========================

    public boolean isAccountCreatedDisplayed() {
        return isDisplayed(accountCreatedMessage);
    }

    public String getAccountCreatedMessage() {
        return getText(accountCreatedMessage);
    }


    // =========================
    // Navigation
    // =========================

    public void clickContinue() {
        clickElement(continueButton);
    }
}