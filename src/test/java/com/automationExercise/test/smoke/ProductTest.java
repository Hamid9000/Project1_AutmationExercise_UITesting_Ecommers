package com.automationExercise.test.smoke;

import com.automationExercise.base.CommonToAllTest;
import com.automationExercise.driver.DriverManager;
import com.automationExercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends CommonToAllTest {

    @Test(description = "Verify Products page is displayed")
    public void verifyProductsPage() {

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        // Navigation
        productsPage.openProductsPage();

        // Verification
        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed"
        );

        Assert.assertTrue(
                productsPage.isProductsUrlDisplayed(),
                "Products URL is not correct"
        );
    }


    @Test(description = "Verify product search")
    public void verifyProductSearch() {

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        // Navigation
        productsPage.openProductsPage();

        // Action
        productsPage.searchProduct("Blue Top");

        // Verification
        Assert.assertTrue(
                productsPage.isSearchResultDisplayed(),
                "Searched Products section is not displayed"
        );
    }


    @Test(description = "Verify category")
    public void verifyCategory() {

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        // Navigation
        productsPage.openProductsPage();

        // Action
        productsPage.selectCategory("Women");

        // Verification
        Assert.assertTrue(
                productsPage.isCategoryDisplayed("Women"),
                "Women category is not displayed"
        );
    }


    @Test(description = "Verify sub-category")
    public void verifySubCategory() {

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        // Navigation
        productsPage.openProductsPage();

        // Action
        productsPage.selectCategory("Women");

        productsPage.selectSubCategory(
                "Women",
                "Tops"
        );

        // Verification
        Assert.assertTrue(
                productsPage.isSubCategoryDisplayed(
                        "Women",
                        "Tops"
                ),
                "Women - Tops sub-category is not displayed"
        );
    }


    @Test(description = "Verify brand")
    public void verifyBrand() {

        ProductsPage productsPage =
                new ProductsPage(DriverManager.getDriver());

        // Navigation
        productsPage.openProductsPage();

        // Action
        productsPage.selectBrand("POLO");

        // Verification
        Assert.assertTrue(
                productsPage.isBrandDisplayed("POLO"),
                "POLO brand is not displayed"
        );
    }
}