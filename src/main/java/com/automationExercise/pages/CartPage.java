package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends CommonToAllPage {

    // URL
    private final String cartUrl = ConfigLoader.get("cart_url");

    // Locators
    private final By proceedToCheckoutButton =
            By.xpath("//a[normalize-space()='Proceed To Checkout']");


    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Open Cart Page
    public void openCartPage() {
        openPage(cartUrl);
    }

    // Cart Actions
    public CheckoutPage clickProceedToCheckout() {
        click(proceedToCheckoutButton);
        return new CheckoutPage(driver);
    }
}