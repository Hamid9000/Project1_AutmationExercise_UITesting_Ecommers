package com.automationExercise.base;

import com.automationExercise.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp() {

        DriverManager.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quit();
    }
}