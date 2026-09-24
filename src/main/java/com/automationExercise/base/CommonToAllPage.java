package com.automationExercise.base;

import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAllPage {

    protected WebDriver driver;

    // Constructor
    public CommonToAllPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================
    // Base URL
    // =========================

    protected void openBaseURL() {
        driver.get(ConfigLoader.get("base_url"));
    }

    protected void openPage(String pageUrl) {
        driver.get(ConfigLoader.get("base_url") + pageUrl);
    }

    // =========================
    // Explicit Wait
    // =========================

    protected WebElement waitForElement(By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // =========================
    // Common Actions
    // =========================

    protected void enterInput(By locator, String value) {

        WebElement element = waitForElement(locator);

        element.clear();
        element.sendKeys(value);
    }

    protected void clickElement(By locator) {

        waitForClickable(locator).click();
    }

    protected String getText(By locator) {

        return waitForElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        return waitForElement(locator).isDisplayed();
    }
}