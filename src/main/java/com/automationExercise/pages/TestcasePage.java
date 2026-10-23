package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestcasePage extends CommonToAllPage {
    // url
    private final String testCasPageUrl = ConfigLoader.get("testCasePage_url");
    // locater
   private final By testCasesTitle = By.xpath("//b[text()='Test Cases']");
   private final By subTitle =By.xpath("//span[contains(text(),'Below is the list')]");

    // constructor
   public TestcasePage (WebDriver driver){
       super(driver);
   }

    /// Action
    public void openTestCasePage() {
        driver.get(testCasPageUrl);
    }

    // Verification
    public boolean isTestCasPageDisplay() {
        return isTitleDisplay();
    }

    public boolean isTestCasesTitleDisplayed() {
        return isDisplayedWithWait(testCasesTitle);
    }

    public boolean isSubTitleDisplayed() {
        return isDisplayedWithWait(subTitle);
    }
}
