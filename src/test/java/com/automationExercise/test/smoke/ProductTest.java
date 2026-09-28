package com.automationExercise.test.smoke;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.ProductsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends CommonToAllTest {

    private static final Logger logger =
            LogManager.getLogger(ProductTest.class);


    // =========================================================
    // TC_PROD_001 - Verify Products Page
    // =========================================================

    @Test(
            description = "TC_PROD_001 - Verify Products page is displayed"
    )
    public void verifyProductsPage() {

        logger.info("Starting test: TC_PROD_001 - Verify Products page is displayed");

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        logger.info("Opening Products page");
        productsPage.openProductsPage();

        logger.info("Verifying Products page is displayed");
        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed"
        );

        logger.info("Verifying Products URL");
        Assert.assertTrue(
                productsPage.isProductsUrlDisplayed(),
                "Products URL is not correct"
        );

        logger.info("Test passed: TC_PROD_001");
    }


    // =========================================================
    // TC_PROD_002 - Verify Product Search
    // =========================================================

    @Test(
            description = "TC_PROD_002 - Verify product search"
    )
    public void verifyProductSearch() {

        logger.info("Starting test: TC_PROD_002 - Verify product search");

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        logger.info("Opening Products page");
        productsPage.openProductsPage();

        logger.info("Searching for product: Blue Top");
        productsPage.searchProduct("Blue Top");

        productsPage.waitFor(10);

        logger.info("Verifying Searched Products section");
        Assert.assertTrue(
                productsPage.isSearchResultDisplayed(),
                "Searched Products section is not displayed"
        );

        logger.info("Test passed: TC_PROD_002");
    }


    // =========================================================
    // TC_PROD_003 - Verify Category
    // =========================================================

    @Test(
            description = "TC_PROD_003 - Verify category"
    )
    public void verifyCategory() {

        logger.info("Starting test: TC_PROD_003 - Verify category");

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        logger.info("Opening Products page");
        productsPage.openProductsPage();

        logger.info("Selecting category: Women");
        productsPage.selectCategory("Women");

        logger.info("Verifying Women category");
        Assert.assertTrue(
                productsPage.isCategoryDisplayed("Women"),
                "Women category is not displayed"
        );

        logger.info("Test passed: TC_PROD_003");
    }


    // =========================================================
    // TC_PROD_004 - Verify Sub-Category
    // =========================================================

    @Test(
            description = "TC_PROD_004 - Verify sub-category"
    )
    public void verifySubCategory() {

        logger.info("Starting test: TC_PROD_004 - Verify sub-category");

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        logger.info("Opening Products page");
        productsPage.openProductsPage();

        logger.info("Selecting category: Women");
        productsPage.selectCategory("Women");

        logger.info("Selecting sub-category: Tops");
        productsPage.selectSubCategory(
                "Women",
                "Tops"
        );

        logger.info("Verifying Women - Tops sub-category");
        Assert.assertTrue(
                productsPage.isSubCategoryDisplayed(
                        "Women",
                        "Tops"
                ),
                "Women - Tops sub-category is not displayed"
        );

        logger.info("Test passed: TC_PROD_004");
    }


    // =========================================================
    // TC_PROD_005 - Verify Brand
    // =========================================================

    @Test(
            description = "TC_PROD_005 - Verify brand"
    )
    public void verifyBrand() {

        logger.info("Starting test: TC_PROD_005 - Verify brand");

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        logger.info("Opening Products page");
        productsPage.openProductsPage();

        logger.info("Selecting brand: POLO");
        productsPage.selectBrand("POLO");

        logger.info("Verifying POLO brand");
        Assert.assertTrue(
                productsPage.isBrandDisplayed("POLO"),
                "POLO brand is not displayed"
        );

        logger.info("Test passed: TC_PROD_005");
    }
}