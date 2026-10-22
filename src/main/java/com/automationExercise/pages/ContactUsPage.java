package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends CommonToAllPage {
    // url
    private final String contactUsUrl = ConfigLoader.get("contactUs_url");

    //locater

    private final By getInTouch = By.className("title");
    private final By nameField = By.name("name");
    private final By emailField = By.name("email");
    private final By subjectField = By.name("subject");
    private final By messageField = By.name("message");
    private final By chooseFileButton = By.name("upload_file");
    private final By submitButton = By.name("submit");
    private final By successMessage = By.xpath("//h2[@class='title text-center']/following-sibling::div[contains(text(),'Success! Your details have been submitted successfully.')]");

    //Construction
    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    //Action
    public void enterName(String name){
        enter(nameField, name);
    }
    public void enterEmail(String email){
        enter(emailField, email);
    }
    public void enterSubject(String entersubject){
        enter(subjectField, entersubject);
    }
    public  void enterYourMessageHere(String yourMessage){
        enter(messageField,yourMessage);
    }
    public void clickChooseFile(String filePath) {
        fileUpload(chooseFileButton, filePath);
    }

    public void clickSubmit(){
        click(submitButton);
    }

    //Assertion
    public String getSuccessMessage(){
        return getText(successMessage);
    }


}
