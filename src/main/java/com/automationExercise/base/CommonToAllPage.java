
package com.automationExercise.base;

import com.automationExercise.config.ConfigLoader;
import com.automationExercise.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CommonToAllPage {

    protected final WebDriver driver;
    protected final WaitUtils waitUtils;

    public CommonToAllPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 10);
    }

    // Navigation
    protected void openBaseURL() {
        driver.get(ConfigLoader.get("base_url"));
    }

    protected void openPage(String pageUrl) {
        driver.get(ConfigLoader.get("base_url") + pageUrl);
    }

    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void navigateForward() {
        driver.navigate().forward();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    // =========================
    // title & current Url
    // =========================

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    // =========================
    // Common UI Actions
    // =========================

    // Click without wait
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    // Click with explicit wait
    protected void clickWithWait(By locator) {
        waitUtils.waitForElementClickable(locator).click();
    }


    // Enter text without wait
    protected void enter(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    // Enter text with explicit wait
    protected void enterWithWait(By locator, String value) {
        WebElement element = waitUtils.waitForElementVisible(locator);
        element.clear();
        element.sendKeys(value);
    }


    // Get text without wait
    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Get text with explicit wait
    protected String getTextWithWait(By locator) {
        return waitUtils.waitForElementVisible(locator).getText();
    }


    // Scroll and click
    protected void scrollAndClick(By locator) {
        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );

        element.click();
    }

    // Scroll and click with explicit wait
    protected void scrollAndClickWithWait(By locator) {
        WebElement element = waitUtils.waitForElementVisible(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );

        waitUtils.waitForElementClickable(locator).click();
    }


    // JavaScript click without explicit wait
    protected void jsClick(By locator) {
        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
        );
    }

    // JavaScript click with explicit wait
    protected void jsClickWithWait(By locator) {
        WebElement element = waitUtils.waitForElementVisible(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
        );
    }


    // =========================
    // File Upload
    // =========================

    // Without explicit wait
    protected void fileUpload(By locator, String filePath) {
        driver.findElement(locator).sendKeys(filePath);
    }

    // With explicit wait
    protected void fileUploadWithWait(By locator, String filePath) {
        waitUtils.waitForElementVisible(locator).sendKeys(filePath);
    }

    // =========================
    // select
    // =========================

    // By text value
    protected void selectDropdownByText(By locator, String text) {
        Select select = new Select(waitUtils.waitForElementVisible(locator));
        select.selectByVisibleText(text);
    }

    protected void selectDropdownByValue(By locater, String value){
        // without making variable can use
        Select select = new Select(driver.findElement(locater));
        select.selectByValue(value);
    }

    protected void selectDropdownByIndex(By locater, int index){
        new Select(driver.findElement(locater)).selectByIndex(index);
    }

    protected String selectDropdownGetText(By locater){
       return new Select(driver.findElement(locater)).getFirstSelectedOption().getText();
    }

    // =========================
    // alert
    // =========================

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
     // ===========================
     // Action
     // ===========================


    // Mouse hover
    protected void mouseHover(By locator) {
        WebElement element = waitUtils.waitForElementVisible(locator);
        new Actions(driver).moveToElement(element).perform();
    }

    // Right click
    protected void rightClick(By locator) {
        WebElement element = waitUtils.waitForElementVisible(locator);
        new Actions(driver).contextClick(element).perform();
    }

    // Double click
    protected void doubleClick(By locator) {
        WebElement element = waitUtils.waitForElementClickable(locator);
        new Actions(driver).doubleClick(element).perform();
    }

    // Drag and drop
    protected void dragAndDrop(By source, By target) {
        WebElement sourceElement = waitUtils.waitForElementVisible(source);
        WebElement targetElement = waitUtils.waitForElementVisible(target);

        new Actions(driver)
                .dragAndDrop(sourceElement, targetElement)
                .perform();
    }

    // =========================
    // Verification
    // =========================

    // Displayed without explicit wait
    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    // Displayed with explicit wait
    protected boolean isDisplayedWithWait(By locator) {
        return waitUtils.waitForElementVisible(locator).isDisplayed();
    }


    // Presence without explicit wait
    protected boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    // Presence with explicit wait
    protected boolean isElementPresentWithWait(By locator) {
        return !waitUtils.waitForElementInvisible(locator);
    }


    // URL verification
    protected boolean isUrlContains(String expectedValue) {
        return driver.getCurrentUrl().contains(expectedValue);
    }

    // Title verification
    protected boolean isTitleContains(String expectedValue) {
        return driver.getTitle().contains(expectedValue);
    }

    //

    protected boolean isTitleDisplay(){
        return  !driver.getTitle().isBlank();
    }
    // wait
    public void waitForFixTime(int time) {
        waitUtils.waitForFixTime(time);
    }
}
