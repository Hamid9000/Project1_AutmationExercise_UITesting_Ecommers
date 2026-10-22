package com.automationExercise.test;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends CommonToAllTest {

    @Test(description = "TC_CART_001 :Verify that user can place an order successfully",
            groups = {"smoke"})
    public void verifyUserCanPlaceOrder() throws InterruptedException {
        String id = "fizejazud@mailinator.com";
        String password = "Pa$$w0rd!";
        String name = "Hamid";
        String cardNumber = "4111111111111111";
        String cvc = "123";
        String month = "12";
        String year = "2008";
        String message = "N/A";

        // Step 1: Open Products page
        ProductsPage productsPage = new ProductsPage(DriverManager.getDriver());

        productsPage.openProductsPage();

        // Step 2: Add product to cart
        productsPage.addToCart();

        // Step 3: Click View Cart
        CartPage cartPage = productsPage.clickViewCart();

        // Step 4: Proceed to checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        // Step 5: Click Register / Login
        LoginPage loginPage = checkoutPage.clickRegistrationLogin();

        // Step 6: Login
        HomePage homePage = loginPage.login(id, password);

        // Step 7: Open Cart after login
        CartPage cartPageAfterLogin = homePage.clickCart();

        // Step 8: Proceed to checkout again
        CheckoutPage checkoutPageAfterLogin = cartPageAfterLogin.clickProceedToCheckout();

        // Step 9: Enter order message
        checkoutPageAfterLogin.enterMessage(message);

        // Step 10: Click Place Order
        PaymentPage paymentPage = checkoutPageAfterLogin.clickPlaceOrderButton();


        // Step 11: Complete payment
        OrderConfirmationPage orderConfirmationPage = paymentPage.completePayment(name, cardNumber, cvc, month, year);

        // Step 12: Verify order confirmation
        Assert.assertTrue(paymentPage.isOrderPlacedMessageDisplayed(), "Order placed message is not displayed");
        Thread.sleep(10000);

    }
}
