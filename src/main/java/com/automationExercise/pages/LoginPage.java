package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {

    // =========================
    // URL
    // =========================

    private String loginUrl =
            ConfigLoader.get("login_url");

    // =========================
    // Locators
    // =========================

    private By loginEmail =
            By.name("email");

    private By loginPassword =
            By.name("password");

    private By loginButton =
            By.cssSelector("[data-qa='login-button']");

    // =========================
    // Constructor
    // =========================

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // Open Login Page
    // =========================

    public void openLoginPage() {
        openPage(loginUrl);
    }

    // =========================
    // Login Actions
    // =========================

    public void enterLoginEmail(String email) {
        enterInput(loginEmail, email);
    }

    public void enterLoginPassword(String password) {
        enterInput(loginPassword, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    // =========================
    // Complete Login
    // =========================

    public void login(String email, String password) {

        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLogin();
    }
}