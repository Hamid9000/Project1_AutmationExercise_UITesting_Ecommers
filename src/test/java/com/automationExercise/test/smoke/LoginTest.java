package com.automationExercise.test.smoke;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.dataprovider.LoginDataProvider;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonToAllTest {

    @Test(
            description = "Verify login functionality with valid credentials",
            groups = {"smoke"},
            dataProvider = "validData",
            dataProviderClass = LoginDataProvider.class
    )
    public void validLoginTest(String email, String password) {

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        loginPage.openLoginPage();

        loginPage.login(email, password);

        Assert.assertFalse(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("login"),
                "User should be logged in successfully"
        );
    }


    @Test(
            description = "Verify login functionality with invalid credentials",
            groups = {"smoke"},
            dataProvider = "inValidData",
            dataProviderClass = LoginDataProvider.class
    )
    public void invalidLoginTest(
            String email,
            String password,
            String expectedErrorMessage) {

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        loginPage.openLoginPage();

        loginPage.login(email, password);

        String actualErrorMessage =
                loginPage.getLoginErrorMessage();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Login error message is not matching"
        );
    }
}