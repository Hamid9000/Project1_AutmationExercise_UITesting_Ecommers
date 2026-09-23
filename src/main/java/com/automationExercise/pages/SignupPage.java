package com.automationExercise.pages;

import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    private WebDriver driver;

    // URL
    private String baseUrl =
            ConfigLoader.get("base_url");

    private String signupUrl =
            ConfigLoader.get("signup_url");

    // Signup Locators
    private By signupName =
            By.name("name");

    private By signupEmail =
            By.name("email");

    private By signupButton =
            By.xpath("//button[@data-qa='signup-button']");

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open Signup Page
    public void openSignupPage() {
        driver.get(baseUrl + signupUrl);
    }

    // Signup Actions
    public void enterSignupName(String name) {
        driver.findElement(signupName).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        driver.findElement(signupEmail).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    public void signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignup();
    }
}