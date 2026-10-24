
package com.automationExercise.test;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.dataprovider.LoginDataProvider;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.listeners.RetryAnalyzer;
import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.LoginPage;

import com.automationExercise.testdata.LoginPageTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonToAllTest {

    @Test(
            description = "TC_LOGIN_002: Verify login with valid credentials",
            groups = {"smoke"},
            dependsOnMethods = {"com.automationExercise.test.SignupTest.verifyValidSignup"},
            priority = 2
            //retryAnalyzer = RetryAnalyzer.class
    )
    public void validLoginTest(){

        String email = SignupTest.registeredEmail;
        String password = SignupTest.registeredPassword;

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        loginPage.openLoginPage();
        HomePage homePage =loginPage.login(email, password);
        Assert.assertTrue(homePage.isLogoutButtonDisplayed(), "Home logout Button Is not displayed");

    }


    @Test(
            description = "TC_LOGIN_003: Verify login with invalid credentials",
            groups = {"smoke"},
            dataProvider = "loginInvalidData",
            dataProviderClass = LoginDataProvider.class,
            priority = 3

            // retryAnalyzer = RetryAnalyzer.class
    )
    public void invalidLoginTest(
            String testCaseID,
            String testType,
            String email,
            String password,
            String expectedErrorMessage) {

        System.out.println("====================================");
        System.out.println("TestCaseID: " + testCaseID);
        System.out.println("TestType: " + testType);
        System.out.println("Test: Invalid Login");
        System.out.println("Email: " + email);
        System.out.println("Expected Error: " + expectedErrorMessage);
        System.out.println("====================================");

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        loginPage.openLoginPage();
        loginPage.login(email, password);

        String actualErrorMessage =
                loginPage.getLoginErrorMessage();

        Assert.assertEquals(
                actualErrorMessage,
                expectedErrorMessage,
                "Error message mismatch for TestCaseID: "
                        + testCaseID
        );

        System.out.println(
                "PASS: " + testCaseID
                        + " - Expected error message displayed"
        );
    }

    @Test(
            description = "TC_LOGIN_004 :Verify that user can logout",
            groups = {"smoke"},
            priority = 4
            //dataProvider = "",
            // dataProverderClass = sfsf.class,
            //retryAnalyzer = RetryAnalyzer.class

    )
    public void registrationTest() {
        String email = LoginPageTestData.email;
        String password = LoginPageTestData.password;

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.openLoginPage();
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        HomePage homePage = loginPage.clickLogin();
        LoginPage logout = homePage.clickLogout();
        Assert.assertTrue(
                logout.isLoginPageDisplayed(),
                "Login page is not displayed after logout"
        );

    }

}
