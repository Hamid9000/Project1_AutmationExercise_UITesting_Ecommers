package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends CommonToAllPage {

    // url
    public String paymentUrl = ConfigLoader.get("payment_url");

    // Locater

    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By submit = By.id("submit");
    private By orderPlace = By.xpath("//h2[@data-qa='order-placed']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private  By invoice = By.xpath("//a[@href='/download_invoice/1300']");

    // Constructer

    public PaymentPage(WebDriver driver){
        super(driver);
    }

    // Open page

    //Action
    public void clickNameOnCard(){
        click(nameOnCard);
    }
    public void clickCardNumber(){
        click(cardNumber);
    }

    public void clickCvc(){
        click(cvc);
    }

    public void clickExpiryMonth(){
        click(expiryMonth);
    }

    public  void clickExpiryYear(){
        click(expiryYear);
    }

    public void clickSubmit(){
        click(submit);
    }
    public  void clickOrderPlace(){
        click(orderPlace);
    }
    public  void clickContinueButton(){
        click(continueButton);
    }

    public void clickInvoice(){
        click(invoice);
    }

}
