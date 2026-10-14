package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends CommonToAllPage {

    // URl

    private String cartUrl =
            ConfigLoader.get("cart_url");

    // Locater

    private By ProceedToCheckout =
            By.xpath("//a[text()='Proceed To Checkout']");
    private By message =
            By.name("message");
    private By cart_delete =
            By.xpath("//a[@data-product-id='1']");
    private By placeOrder =
            By.xpath("//a[@href='/payment']");

    // Constructor

    public CartPage(WebDriver driver){
        super(driver);
    }

    // Open cart Page

   public void openCartPage(){
       openPage(cartUrl);
    }

    // Cart Action

    public void clickProceedToCheckout(){
        click(ProceedToCheckout);
    }

    public void clickDeleteItem(){
        click(cart_delete );
    }

    public void enterText(String text){
        enter(message, text);
    }

    public  void clickPlaceorder(){
        click(placeOrder);
    }

    // Complete Cart

    // Add cart verification
}


