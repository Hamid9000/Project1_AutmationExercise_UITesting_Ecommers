package com.automationExercise.test;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.dataprovider.SignupDataProvider;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.listeners.RetryAnalyzer;
import com.automationExercise.pages.AccountCreatedPage;
import com.automationExercise.pages.AccountInformationPage;
import com.automationExercise.pages.SignupPage;
import com.automationExercise.utils.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SignupTest extends CommonToAllTest {

    private static final Logger logger = LoggerFactory.getLogger(SignupTest.class);

    // ============================================================
    // Test Case Info
    // ============================================================
    private static final String TC_SIGNUP_01 = "TC_SIGNUP_01";
    private static final String TC_SIGNUP_01_NAME = "Verify that a new user can successfully create an account with valid details";


    // ============================================================
    // Positive Test : Signup
    // ============================================================

    @Test(
            dataProvider = "signupData",                    // ← yeh missing tha
            dataProviderClass = SignupDataProvider.class,
            description = TC_SIGNUP_01 + " : " + TC_SIGNUP_01_NAME,
            groups = {"smoke"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void verifyValidSignup(
            String testCaseId,
            String testType,
            String title,
            String name,
            String email,
            String password,
            String dobDay,
            String dobMonth,
            String dobYear,
            String newsletter,
            String specialOffers,
            String firstName,
            String lastName,
            String company,
            String address,
            String address2,
            String country,
            String state,
            String city,
            String zipcode,
            String mobile) {

        // Store email and password for cleanup
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("email", email);
        result.setAttribute("password", password);

        logger.info("=================================================");
        logger.info("Test Case ID   : {}", testCaseId);
        logger.info("Test Case Name : {}", TC_SIGNUP_01_NAME);
        logger.info("Test Type      : {}", testType);
        logger.info("User Name      : {}", name);
        logger.info("=================================================");

        SignupPage signupPage = new SignupPage(DriverManager.getDriver());

        logger.info("Opening Signup page");
        AccountInformationPage accountInformationPage = signupPage
                .openSignupPage()
                .signup(name, email);

        logger.info("Signup details submitted successfully");
        logger.info("Filling account information for user: {}", name);

        accountInformationPage.fillAccountInformation(
                title, password, dobDay, dobMonth, dobYear,
                newsletter, specialOffers, firstName, lastName,
                company, address, address2, country, state,
                city, zipcode, mobile
        );

        logger.info("Account information filled successfully");
        logger.info("Creating account");

        AccountCreatedPage accountCreatedPage =
                accountInformationPage.navigateToAccountCreated();

        logger.info("Verifying Account Created message");

        Assert.assertTrue(
                accountCreatedPage.isAccountCreatedDisplayed(),
                "Account Created message is not displayed"
        );

        logger.info("Test Case {} - {} --> PASSED", testCaseId, TC_SIGNUP_01_NAME);
    }


    // ============================================================
    // Test Data Cleanup
    // ============================================================

    @AfterMethod(alwaysRun = true)
    public void cleanupTestData(ITestResult result) {

        String email = (String) result.getAttribute("email");
        String password = (String) result.getAttribute("password");

        if (email != null && password != null) {

            boolean deleted = UserApi.deleteUser(email, password);

            if (deleted) {
                logger.info("Test data cleanup successful for: {}", email);
            } else {
                logger.warn("Test data cleanup failed for: {}", email);
            }
        }
    }
}