package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends CommonToAllPage {

    // =========================
    // URL
    // =========================

    public void openProductsPage() {
        openPage(ConfigLoader.get("products_url"));
    }


    // =========================
    // Search
    // =========================

    private By searchProductBox = By.id("search_product");

    private By searchButton = By.id("submit_search");


    // =========================
    // Products
    // =========================

    private By allProducts = By.className("features_items");

    private By searchedProductsTitle =
            By.xpath("//h2[contains(text(),'Searched Products')]");


    // =========================
    // Category
    // =========================

    private By category(String categoryName) {

        return By.xpath(
                "//a[@href='#" + categoryName + "']"
        );
    }


    // =========================
    // Sub Category
    // =========================

    private By subCategory(
            String categoryName,
            String subCategoryName) {

        return By.xpath(
                "//div[@id='" + categoryName +
                        "']//a[contains(text(),'" +
                        subCategoryName + "')]"
        );
    }


    // =========================
    // Brands
    // =========================

    private By brand(String brandName) {

        return By.xpath(
                "//div[@class='brands-name']//a[contains(.,'" +
                        brandName + "')]"
        );
    }


    // =========================
    // Constructor
    // =========================

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    // =========================
    // Actions
    // =========================

    public void searchProduct(String productName) {

        enter(searchProductBox, productName);

        click(searchButton);
    }


    public void selectCategory(String categoryName) {

        click(category(categoryName));
    }


    public void selectSubCategory(
            String categoryName,
            String subCategoryName) {

        click(
                subCategory(
                        categoryName,
                        subCategoryName
                )
        );
    }


    public void selectBrand(String brandName) {

        click(brand(brandName));
    }


    // =========================
    // Verifications
    // =========================

    public boolean isProductsPageDisplayed() {

        return isDisplayed(allProducts);
    }


    public boolean isSearchResultDisplayed() {

        return isDisplayed(searchedProductsTitle);
    }


    public boolean isCategoryDisplayed(String categoryName) {

        return isDisplayed(category(categoryName));
    }


    public boolean isSubCategoryDisplayed(
            String categoryName,
            String subCategoryName) {

        return isDisplayed(
                subCategory(
                        categoryName,
                        subCategoryName
                )
        );
    }


    public boolean isBrandDisplayed(String brandName) {

        return isDisplayed(brand(brandName));
    }


    public boolean isProductsUrlDisplayed() {

        return isUrlContains(
                ConfigLoader.get("products_url")
        );
    }
}