package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends CommonToAllPage {

    // =========================
    // URL
    // =========================
    protected String productUrl = ConfigLoader.get("products_url");


    // =========================
    // Search
    // =========================

    private By searchProductBox = By.id("search_product");

    private By searchButton = By.id("submit_search");

    private By blueTop = By.xpath("//div[contains(@class,'features_items')]//div[contains(@class,'productinfo')][p[normalize-space()='Blue Top']]/a[contains(@class,'add-to-cart')]");
    // =========================
    // Products
    // =========================

    private By allProducts = By.className("features_items");

    private By searchedProductsTitle =
            By.xpath("//h2[contains(text(),'Searched Products')]");

    private final By productList =
            By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");

    private final  By allProductsTitle =
            By.xpath("//h2[text()='All Products']");

    //product details


    private final By productName = By.xpath("//div[@class='product-information']/h2");

    private final By category = By.xpath("//div[@class='product-information']/p[1]");

    private final By price = By.xpath("//div[@class='product-information']/span/span");

    private final By availability = By.xpath("//div[@class='product-information']/p[2]");

    private final By condition = By.xpath("//div[@class='product-information']/p[3]");

    private final By brand = By.xpath("//div[@class='product-information']/p[4]");

    //=============================
    // Modal cart
    // ===========================
    private By viewCart = By.xpath("//a[@href='/view_cart' ]/ u[text()='View Cart']");
    private By continueShopping = By.xpath("//button[text()='Continue Shopping']");
    private By viewProductButton = By.xpath("//a[text()='View Product']");


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
    // Open Product  Page
    // =========================
    public void openProductsPage() {
        openPage(productUrl);
    }

    // =========================
    // Navigation
    // =========================

    public  void navigateToAllProductList(){
        mouseHover(allProductsTitle);
    }


    // =========================
    // Actions
    // =========================

    public String getProductPageUrl(){
        return driver.getCurrentUrl();
    }
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

    public void addToCart() {
        scrollAndClick(blueTop);
    }

    public CartPage clickViewCart() {
        click(viewCart);
        return new CartPage(driver);
    }

    public void clickContinueShopping() {
        click(continueShopping);
    }

    public void clickOnProduct(int productNum){
        List<WebElement> products = driver.findElements(productList);
            if (products.size()>productNum) {
                products.get(productNum).click();
            }

    }

    public  void clickOnViewProduct(int productNum){
        List<WebElement> products = driver.findElements(productList);
        if (products.size()>productNum){
            products.get(productNum).findElement(viewProductButton).click();
        }
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

    public boolean isProductListDisplay() {
        List<WebElement> products = driver.findElements(productList);

        if (products.isEmpty()) return false;

        for (WebElement product : products) {
            if (!product.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public boolean isAllProductsTitleDisplayed() {
        return isDisplayedWithWait(allProductsTitle);
    }

    public String getProductName() {
        return waitUtils.waitForElementVisible(productName).getText();
    }
    // product detail verification

    public boolean isProductNameDisplayed() {
        return isDisplayedWithWait(productName);
    }

    public boolean isCategoryDisplayed() {
        return isDisplayedWithWait(category);
    }

    public boolean isPriceDisplayed() {
        return isDisplayedWithWait(price);
    }

    public boolean isAvailabilityDisplayed() {
        return isDisplayedWithWait(availability);
    }

    public boolean isConditionDisplayed() {
        return isDisplayedWithWait(condition);
    }

    public boolean isBrandDisplayed() {
        return isDisplayedWithWait(brand);
    }
}