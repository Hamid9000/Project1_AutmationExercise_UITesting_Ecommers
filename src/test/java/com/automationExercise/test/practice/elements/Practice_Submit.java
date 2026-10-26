package com.automationExercise.test.practice.elements;


import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Practice_Submit extends CommonToAllTest {
    @Test
    public void verifySubmit(){
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("hamid");
        driver.findElement(By.id("password")).sendKeys(("12345"));
        driver.findElement(By.id("submit")).click();
    }
}
