package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonToAllPage {

    // =========================
    // Home Page Locators
    // =========================

    private By home =
            By.xpath("//a[contains(text(),'Home')]");

    private By products =
            By.xpath("//a[contains(text(),'Products')]");

    private By cart =
            By.xpath("//a[contains(text(),'Cart')]");

    private By logout =
            By.xpath("//a[contains(text(),'Logout')]");

    private By deleteAccount =
            By.xpath("//a[contains(text(),'Delete Account')]");

    private By testCases =
            By.xpath("//a[contains(text(),'Test Cases')]");

    private By apiTesting =
            By.xpath("//a[contains(text(),'API Testing')]");

    private By videoTutorials =
            By.xpath("//a[contains(text(),'Video Tutorials')]");

    private By contactUs =
            By.xpath("//a[contains(text(),'Contact us')]");

    private By loggedInAs =
            By.xpath("//a[contains(text(),'Logged in as')]");


    // =========================
    // Constructor
    // =========================

    public HomePage(WebDriver driver) {
        super(driver);
    }


    // =========================
    // Verification
    // =========================

    public boolean isHomePageDisplayed() {

        return driver.findElement(home).isDisplayed();
    }

    public boolean isLoggedInAsDisplayed() {

        return driver.findElement(loggedInAs).isDisplayed();
    }


    // =========================
    // Navigation Actions
    // =========================

    public void clickHome() {

        driver.findElement(home).click();
    }

    public void clickProducts() {

        driver.findElement(products).click();
    }

    public void clickCart() {

        driver.findElement(cart).click();
    }

    public void clickLogout() {

        driver.findElement(logout).click();
    }

    public void clickDeleteAccount() {

        driver.findElement(deleteAccount).click();
    }

    public void clickTestCases() {

        driver.findElement(testCases).click();
    }

    public void clickApiTesting() {

        driver.findElement(apiTesting).click();
    }

    public void clickVideoTutorials() {

        driver.findElement(videoTutorials).click();
    }

    public void clickContactUs() {

        driver.findElement(contactUs).click();
    }


    // =========================
    // Logged-in User
    // =========================

    public String getLoggedInUserText() {

        return driver.findElement(loggedInAs).getText();
    }
}