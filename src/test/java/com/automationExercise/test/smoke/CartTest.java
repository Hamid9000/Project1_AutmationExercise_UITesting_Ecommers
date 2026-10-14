package com.automationExercise.test.smoke;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.CartPage;
import com.automationExercise.pages.ProductsPage;
import org.testng.annotations.Test;

public class CartTest extends CommonToAllTest {

    @Test(
      description = "Verify that user can place order"
    )
    public void verifyUserCanOrder() throws InterruptedException{
        // step1 : open product page
        ProductsPage productsPage = new ProductsPage(DriverManager.getDriver());

        // Step2: Open Product Page
        productsPage.openProductsPage();

        //Step3: add product to cart
        productsPage.addToCart();
      //  Thread.sleep(10000);


       // Step 4: click view cart and redireted to view cart page
        CartPage cartPage = productsPage.clickViewCart();



    }
}
