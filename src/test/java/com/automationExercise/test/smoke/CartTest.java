package com.automationExercise.test.smoke;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.CartPage;
import org.testng.annotations.Test;

public class CartTest extends CommonToAllTest {

    @Test(
      description = "Verify that user can place order"
    )
    public void verifyUserCanOrder(){
        CartPage cartPage = new CartPage(DriverManager.getDriver());
        cartPage.openCartPage();
        cartPage.

    }
}
