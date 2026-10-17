package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {

    // URL
    private final String loginUrl = ConfigLoader.get("login_url");

    // Locators
    private final By loginEmailField = By.name("email");

    private final By loginPasswordField = By.name("password");

    private final By loginButton =
            By.cssSelector("[data-qa='login-button']");

    private final By loginErrorMessage =
            By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");


    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Open Login Page
    public void openLoginPage() {
        openPage(loginUrl);
    }

    // Login Actions
    public void enterLoginEmail(String email) {
        enter(loginEmailField, email);
    }

    public void enterLoginPassword(String password) {
        enter(loginPasswordField, password);
    }

    public HomePage clickLogin() {
        click(loginButton);
        return new HomePage(driver);
    }

    // Complete Login
    public HomePage login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        return clickLogin();
    }



    // Login Verification
    public String getLoginErrorMessage() {
        return getText(loginErrorMessage);
    }
}