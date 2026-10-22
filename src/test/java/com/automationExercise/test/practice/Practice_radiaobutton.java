package com.automationExercise.test.practice;

import com.automationExercise.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice_radiaobutton {
    WebDriver driver ;
    @BeforeMethod
    public void setup(){
        DriverManager.initDriver();
         driver = DriverManager.getDriver();
    }

    @Test
    public void verifRadioButton(){
        driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");
        driver.manage().window().maximize();

    }
}
