package com.automationExercise.base;

import com.automationExercise.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
      //  System.out.println("Before browser initialization");

        DriverManager.initDriver();
//        System.out.println(
//                "Driver after initialization: " + DriverManager.getDriver()
//        );

       // System.out.println("After browser initialization");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quit();
    }
}