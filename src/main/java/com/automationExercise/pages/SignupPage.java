package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends CommonToAllPage {

    // =========================
    // URL
    // =========================

    private final String baseUrl =
            ConfigLoader.get("base_url");

    private final String signupUrl =
            ConfigLoader.get("signup_url");


    // =========================
    // Signup Locators
    // =========================

    private final By signupName =
            By.name("name");

    private final By signupEmail =
            By.xpath("//input[@data-qa='signup-email']");

    private final By signupButton =
            By.xpath("//button[@data-qa='signup-button']");


    // =========================
    // Signup Verification
    // =========================

    // Application error message for already registered email
    private final By signupErrorMessage =
            By.xpath("//p[contains(text(),'Email Address already exist!')]");


    // =========================
    // Constructor
    // =========================

    public SignupPage(WebDriver driver) {
        super(driver);
    }


    // =========================
    // Page Navigation
    // =========================

    public SignupPage openSignupPage() {
        driver.get(baseUrl + signupUrl);
        return this;
    }

    public AccountInformationPage navigateToAccountInformation() {
        clickElement(signupButton);
        return new AccountInformationPage(driver);
    }


    // =========================
    // Signup Actions
    // =========================

    public void enterSignupName(String name) {
        enterInput(signupName, name);
    }

    public void enterSignupEmail(String email) {
        enterInput(signupEmail, email);
    }

    // Click Signup button
    public void clickSignupButton() {
        clickElement(signupButton);
    }


    // =========================
    // Complete Signup
    // =========================

    public AccountInformationPage signup(String name, String email) {

        enterSignupName(name);
        enterSignupEmail(email);

        return navigateToAccountInformation();
    }


    // =========================
    // Application Error Validation
    // =========================

    // Verify whether the existing email error message is displayed
    public boolean isSignupErrorDisplayed() {
        return waitForElement(signupErrorMessage).isDisplayed();
    }

    // Get the existing email error message displayed on the UI
    public String getSignupErrorMessage() {
        return waitForElement(signupErrorMessage).getText();
    }


    // =========================
    // Browser Validation
    // =========================

    // Get browser validation message for Name field
    public String getNameValidationMessage() {
        return driver.findElement(signupName)
                .getAttribute("validationMessage");
    }

    // Verify whether browser validation message is displayed for Name
    public boolean isNameValidationDisplayed() {
        return !getNameValidationMessage().isEmpty();
    }

    // Get browser validation message for Email field
    public String getEmailValidationMessage() {
        return driver.findElement(signupEmail)
                .getAttribute("validationMessage");
    }

    // Verify whether browser validation message is displayed for Email
    public boolean isEmailValidationDisplayed() {
        return !getEmailValidationMessage().isEmpty();
    }
}