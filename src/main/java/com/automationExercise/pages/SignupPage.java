
package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends CommonToAllPage {

    // URL
    private final String baseUrl = ConfigLoader.get("base_url");
    private final String signupUrl = ConfigLoader.get("signup_url");

    // Locators
    private final By signupNameField = By.name("name");
    private final By signupEmailField =
            By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton =
            By.xpath("//button[@data-qa='signup-button']");

    // Error message
    private final By signupErrorMessage =
            By.xpath("//p[contains(text(),'Email Address already exist!')]");

    // Constructor
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    // Page navigation
    public SignupPage openSignupPage() {
        driver.get(baseUrl + signupUrl);
        return this;
    }

    // Signup actions
    public void enterSignupName(String name) {
        enter(signupNameField, name);
    }

    public void enterSignupEmail(String email) {
        enter(signupEmailField, email);
    }

    public void clickSignupButton(){
        click(signupButton);
    }
    public AccountInformationPage signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        click(signupButton);

        return new AccountInformationPage(driver);
    }

    // Error validation
    public boolean isSignupErrorDisplayed() {
        return waitForElement(signupErrorMessage).isDisplayed();
    }

    public String getActualSignupErrorMessage() {
        return waitForElement(signupErrorMessage).getText();
    }

    // Browser validation
    public String getNameValidationMessage() {
        return driver.findElement(signupNameField)
                .getAttribute("validationMessage");
    }

    public boolean isNameValidationDisplayed() {
        return !getNameValidationMessage().isEmpty();
    }

    public String getEmailValidationMessage() {
        return driver.findElement(signupEmailField)
                .getAttribute("validationMessage");
    }

    public boolean isEmailValidationDisplayed() {
        return !getEmailValidationMessage().isEmpty();
    }
}
