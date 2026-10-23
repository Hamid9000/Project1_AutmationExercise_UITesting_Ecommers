package com.automationExercise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriverWait wait;

    //Constructor

    public WaitUtils(WebDriver driver, int timeout) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // Wait until element is visible

    public WebElement waitForElementVisible(By locater){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
    }

    // Wait until element is clickable

    public WebElement waitForElementClickable(By locater){
        return wait.until(ExpectedConditions.elementToBeClickable(locater));
    }

    // Wait until element becomes invisible or disappears
    public boolean waitForElementInvisible(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    public boolean waitForElementPresent(By locator) {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        ) != null;
    }
    // Wait until the old element becomes stale
    public boolean waitForElementStale(WebElement element) {
        return wait.until(
                ExpectedConditions.stalenessOf(element)
        );
    }

    // Wait for a refreshed element condition
    public WebElement waitForRefreshedElement(By locator) {
        return wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                )
        );
    }

    public void waitForFixTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread sleep was interrupted", e);
        }
    }
}

