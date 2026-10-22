package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends CommonToAllPage {

    // URL
    private final String paymentUrl = ConfigLoader.get("payment_url");

    // Locators
    private final By nameOnCardField = By.name("name_on_card");
    private final By cardNumberField = By.name("card_number");
    private final By cvcField = By.name("cvc");
    private final By expiryMonthField = By.name("expiry_month");
    private final By expiryYearField = By.name("expiry_year");
    private final By payAndConfirmOrderButton = By.id("submit");
    private final By orderPlacedMessage =
            By.xpath("//h2[@data-qa='order-placed']");
    private final By continueButton =
            By.xpath("//a[@data-qa='continue-button']");
    private final By invoiceLink =
            By.xpath("//a[contains(@href,'/download_invoice/')]");

    // Constructor
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // Open Payment Page
    public void openPaymentPage() {
        openPage(paymentUrl);
    }

    // Payment Actions
    public void enterNameOnCard(String name) {
        enter(nameOnCardField, name);
    }

    public void enterCardNumber(String number) {
        enter(cardNumberField, number);
    }

    public void enterCvc(String cvcNumber) {
        enter(cvcField, cvcNumber);
    }

    public void enterExpiryMonth(String month) {
        enter(expiryMonthField, month);
    }

    public void enterExpiryYear(String year) {
        enter(expiryYearField, year);
    }

    public OrderConfirmationPage clickPayAndConfirmOrder() {
        click(payAndConfirmOrderButton);
        return new OrderConfirmationPage(driver);
    }

    // Order Verification
    public boolean isOrderPlacedMessageDisplayed() {
        return driver.findElement(orderPlacedMessage).isDisplayed();
    }

    // Navigation
    public HomePage clickContinueButton() {
        click(continueButton);
        return new HomePage(driver);
    }

    // Invoice
    public void clickInvoiceLink() {
        click(invoiceLink);
    }



    // Full Payment
    public OrderConfirmationPage completePayment(
            String name,
            String cardNumber,
            String cvc,
            String month,
            String year) {

        enterNameOnCard(name);
        enterCardNumber(cardNumber);
        enterCvc(cvc);
        enterExpiryMonth(month);
        enterExpiryYear(year);

        return clickPayAndConfirmOrder();
    }
}