package com.automationExercise.test.smoke;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.*;
import org.testng.annotations.Test;

public class CartTest extends CommonToAllTest {

    @Test(
            description = "Verify that user can place order"
    )
    public void verifyUserCanOrder() throws InterruptedException {

        String id = "fizejazud@mailinator.com";
        String password = "Pa$$w0rd!";

        // Step 1: Open Products page
        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        productsPage.openProductsPage();

        // Step 2: Add product to cart
        productsPage.addToCart();

        // Step 3: Click View Cart
        CartPage cartPage = productsPage.clickViewCart();

        // Step 4: Proceed to checkout
        CheckoutPage checkoutPage =
                cartPage.clickProceedToCheckout();

        // Step 5: Click Register / Login
        LoginPage loginPage =
                checkoutPage.clickRegistrationLogin();

        // Step 6: Login
        HomePage homePage = loginPage.login(id, password);

        // Step 7: Open Cart after login
        CartPage cartPageAfterLogin = homePage.clickCart();

        // Step 8: Proceed to checkout again
        CheckoutPage checkoutPageAfterLogin =
                cartPageAfterLogin.clickProceedToCheckout();

        // Step 9: Enter order message
        checkoutPageAfterLogin.enterMessage("N/A");

        // Step 10: Click Place Order
        PaymentPage paymentPage =
                checkoutPageAfterLogin.clickPlaceOrderButton();

        Thread.sleep(10000);

        // Step 11: Enter payment details
        // Call your existing PaymentPage methods here.

        // Step 12: Verify order confirmation
        // Add an assertion for the ORDER PLACED! message.
    }
}
