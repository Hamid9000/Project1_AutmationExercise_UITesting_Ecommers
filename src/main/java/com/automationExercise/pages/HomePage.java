package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonToAllPage {

    // Home Page Locators
    private final By homeLink =
            By.xpath("//a[contains(text(),'Home')]");

    private final By productsLink =
            By.xpath("//a[contains(text(),'Products')]");

    private final By cartLink =
            By.xpath("//a[contains(text(),'Cart')]");

    private final By logoutLink =
            By.xpath("//a[contains(text(),'Logout')]");

    private final By deleteAccountLink =
            By.xpath("//a[contains(text(),'Delete Account')]");

    private final By testCasesLink =
            By.xpath("//a[contains(text(),'Test Cases')]");

    private final By apiTestingLink =
            By.xpath("//a[contains(text(),'API Testing')]");

    private final By videoTutorialsLink =
            By.xpath("//a[contains(text(),'Video Tutorials')]");

    private final By contactUsLink =
            By.xpath("//a[contains(text(),'Contact us')]");

    private final By loggedInAsLink =
            By.xpath("//a[contains(text(),'Logged in as')]");

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Verification
    public boolean isHomePageDisplayed() {
        return driver.findElement(homeLink).isDisplayed();
    }

    public boolean isLoggedInAsDisplayed() {
        return driver.findElement(loggedInAsLink).isDisplayed();
    }

    // Navigation Actions
    public HomePage clickHome() {
        click(homeLink);
        return this;
    }

    public ProductsPage clickProducts() {
        click(productsLink);
        return new ProductsPage(driver);
    }

    public CartPage clickCart() {
        click(cartLink);
        return new CartPage(driver);
    }

    public HomePage clickLogout() {
        click(logoutLink);
        return this;
    }

    public HomePage clickDeleteAccount() {
        click(deleteAccountLink);
        return this;
    }

    public HomePage clickTestCases() {
        click(testCasesLink);
        return this;
    }

    public HomePage clickApiTesting() {
        click(apiTestingLink);
        return this;
    }

    public HomePage clickVideoTutorials() {
        click(videoTutorialsLink);
        return this;
    }

    public HomePage clickContactUs() {
        click(contactUsLink);
        return this;
    }

    // Logged-in User
    public String getLoggedInUserText() {
        return driver.findElement(loggedInAsLink).getText();
    }
}