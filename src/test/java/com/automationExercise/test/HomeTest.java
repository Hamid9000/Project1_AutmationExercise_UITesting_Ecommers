package com.automationExercise.test;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.ContactUsPage;
import com.automationExercise.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest extends CommonToAllTest {

    @Test(
            description = "TC_HOME_006: Verify that Contact us form submitting successfully",
            priority = 6,
            groups = {"smoke"}
    )
    public void ContactUsFormTest() {
        String expectedPageTitle = "Automation Exercise";
        String name ="Hamid";
        String email ="hamidsheikh858@gmail.com";
        String subject ="Money debit not transfer";
        String message ="No comment";
        String filePath ="C:\\Users\\hamid\\IdeaProjects\\Project1_AutmationExercise_UITesting_Ecommers\\src\\test\\resources\\testdata\\test.txt";
        String actualMessage="Success! Your details have been submitted successfully.";


        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.openHomePage();
        Assert.assertEquals(homePage.getTitle(), expectedPageTitle, "Home page is not displayed");
        ContactUsPage contactUsPage = homePage.clickContactUs();
        contactUsPage.fillContactusForm(name, email,subject,message,filePath);
        contactUsPage.acceptAlert();
        Assert.assertEquals(contactUsPage.getSuccessMessage(),actualMessage,"Expected and actual message is not match");

    }
}


