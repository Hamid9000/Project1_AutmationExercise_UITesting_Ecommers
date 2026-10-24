
package com.automationExercise.base;

import com.automationExercise.driver.DriverManager;
import com.automationExercise.test.SignupTest;
import com.automationExercise.utils.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    // Logger object - class level
    private static final Logger logger =
            LoggerFactory.getLogger(CommonToAllTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void cleanupTestData() {

        String email = SignupTest.registeredEmail;
        String password = SignupTest.registeredPassword;

        if (email != null && password != null) {

            boolean deleted = UserApi.deleteUser(email, password);

            if (deleted) {
                logger.info("Test data cleanup successful");
            } else {
                logger.warn("Test data cleanup failed");
            }

        } else {
            logger.info("No test data available for cleanup");
        }
    }
}
