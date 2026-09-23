package com.automationExercise.test.smoke;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonToAllTest {

    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Test(
            description = "TC-001: Verify user is able to login with valid credentials",
            groups = {"smoke"}
    )
    public void validLoginTest() {

        logger.info("Starting TC-001: Valid Login Test");

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        logger.info("Opening Login Page");
        loginPage.openLoginPage();

        logger.info("Entering valid login credentials");
        loginPage.login(
                "validemail@gmail.com",
                "validPassword"
        );

        logger.info("Verifying successful login");

        Assert.assertTrue(
                DriverManager.getDriver().getCurrentUrl().contains("/account"),
                "User is not logged in successfully"
        );

        logger.info("TC-001 passed successfully");
    }

    @Test(
            description = "TC-002: Verify user is not able to login with invalid credentials",
            groups = {"smoke"}
    )
    public void invalidLoginTest() {

        logger.info("Starting TC-002: Invalid Login Test");

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        logger.info("Opening Login Page");
        loginPage.openLoginPage();

        logger.info("Entering invalid login credentials");
        loginPage.login(
                "invalidefdmail@gmail.com",
                "wrofngPassword"
        );

        logger.info("Verifying invalid login error message");

        Assert.assertTrue(
                DriverManager.getDriver().getPageSource()
                        .contains("Your email or password is incorrect!"),
                "Invalid login error message is not displayed"
        );

        logger.info("TC-002 passed successfully");
    }
}