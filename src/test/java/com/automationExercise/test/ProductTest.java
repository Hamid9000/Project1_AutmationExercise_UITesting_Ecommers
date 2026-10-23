package com.automationExercise.test;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.ProductsPage;
import com.automationExercise.utils.AssertionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ProductTest extends CommonToAllTest {

    private static final Logger logger =
            LogManager.getLogger(ProductTest.class);

    // TC_PROD_008 - Verify Product Details
    @Test(
            description = "TC_PROD_008: Verify product details are visible",
            groups = {"smoke"}
    )
    public void verifyProductsPage() {

        String expectedProductName = "Blue Top";
        int productNum = 1;

        AssertionUtils assertion = new AssertionUtils();

        logger.info("========== TC_PROD_008 STARTED ==========");
        logger.info("Expected product name: {}", expectedProductName);
        logger.info("Product number: {}", productNum);

        HomePage homePage = new HomePage(DriverManager.getDriver());

        logger.info("Opening Home Page");
        homePage.openHomePage();

        logger.info("Verifying Home Page is displayed");
        assertion.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page is not displayed"
        );

        logger.info("Navigating to Products Page");
        ProductsPage productsPage = homePage.clickProducts();

        logger.info("Opening All Products list");
        productsPage.navigateToAllProductList();

        logger.info("Verifying All Products title is displayed");
        assertion.assertTrue(
                productsPage.isAllProductsTitleDisplayed(),
                "Products list title is not displayed"
        );

        logger.info("Verifying product list is displayed");
        assertion.assertTrue(
                productsPage.isProductListDisplay(),
                "Product list is not displayed"
        );

        logger.info("Clicking product number: {}", productNum);
        productsPage.clickOnProduct(productNum);

        logger.info("Clicking View Product for product number: {}", productNum);
        productsPage.clickOnViewProduct(productNum);

        logger.info("Current Product Details URL: {}",
                productsPage.getProductPageUrl());

        logger.info("Verifying navigation to Product Details page");
        assertion.assertTrue(
                productsPage.getProductPageUrl().contains("/product"),
                "User is not navigated to Product Details page"
        );
        System.out.println(productsPage.getProductPageUrl());

        logger.info("Verifying product name. Expected: {}", expectedProductName);
        assertion.assertEquals(
                productsPage.getProductName(),
                expectedProductName,
                "Incorrect product details page opened"
        );

        logger.info("Verifying product name visibility");
        assertion.assertTrue(
                productsPage.isProductNameDisplayed(),
                "Product name is not displayed"
        );

        logger.info("Verifying category visibility");
        assertion.assertTrue(
                productsPage.isCategoryDisplayed(),
                "Category is not displayed"
        );

        logger.info("Verifying price visibility");
        assertion.assertTrue(
                productsPage.isPriceDisplayed(),
                "Price is not displayed"
        );

        logger.info("Verifying availability visibility");
        assertion.assertTrue(
                productsPage.isAvailabilityDisplayed(),
                "Availability is not displayed"
        );

        logger.info("Verifying condition visibility");
        assertion.assertTrue(
                productsPage.isConditionDisplayed(),
                "Condition is not displayed"
        );

        logger.info("Verifying brand visibility");
        assertion.assertTrue(
                productsPage.isBrandDisplayed(),
                "Brand is not displayed"
        );

        logger.info("Executing assertAll() to report any failed assertions");
        assertion.assertAll();

        logger.info("All assertions passed");
        logger.info("========== TC_PROD_008 PASSED ==========");
    }
}
