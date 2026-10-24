package com.automationExercise.test;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.TestcasePage;
import com.automationExercise.utils.AssertionUtils;
import org.testng.annotations.Test;

public class TestCaseTest extends CommonToAllTest {
    @Test(
            description = "TC_TC_007: Verify that test case page is dispalay",
            groups = {"smoke"},
            priority = 7
    )
    public void verifyTestCaseDisplay(){

        AssertionUtils assertion = new AssertionUtils();

        TestcasePage testcasePage =
                new TestcasePage(DriverManager.getDriver());

        testcasePage.openTestCasePage();

        assertion.assertTrue(
                testcasePage.isTestCasPageDisplay(),
                "Test Cases page title is incorrect"
        );

        assertion.assertTrue(
                testcasePage.isTestCasesTitleDisplayed(),
                "Test Cases heading is not displayed"
        );

        assertion.assertTrue(
                testcasePage.isSubTitleDisplayed(),
                "Test Cases subtitle is not displayed"
        );

        assertion.assertAll();
    }
}
