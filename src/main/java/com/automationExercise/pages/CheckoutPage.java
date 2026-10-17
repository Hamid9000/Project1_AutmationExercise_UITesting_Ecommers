package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends CommonToAllPage {

    // URL
    protected String checkoutUrl = ConfigLoader.get("checkout_url");

    // Locators
    private final By messageTextArea = By.name("message");
    private final By deleteItemButton =
            By.xpath("//a[@data-product-id='1']");
    private final By placeOrderButton =
            By.xpath("//a[@href='/payment']");
    private final By registrationLoginButton =
            By.xpath("//div[@class='modal-body']//a[@href='/login']");

    private final By continueOnCartButton = By.xpath("//button[text()='Continue On Cart']");


    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void openCheckoutPage() {
        openPage(checkoutUrl);
    }

    public void clickDeleteItemButton() {
        click(deleteItemButton);
    }

    public void enterMessage(String text) {
        enter(messageTextArea, text);
    }

    public PaymentPage clickPlaceOrderButton() {
        click(placeOrderButton);
        return new PaymentPage(driver);
    }
    public LoginPage clickRegistrationLogin(){
        click(registrationLoginButton);
        return new LoginPage(driver);
    }
}