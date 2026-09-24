package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage extends CommonToAllPage {

    // =========================
    // Title
    // =========================

    private By mrRadioButton =
            By.id("id_gender1");

    private By mrsRadioButton =
            By.id("id_gender2");


    // =========================
    // Account Information
    // =========================

    private By name =
            By.id("name");

    private By email =
            By.id("email");

    private By password =
            By.id("password");


    // =========================
    // Date of Birth
    // =========================

    private By day =
            By.id("days");

    private By month =
            By.id("months");

    private By year =
            By.id("years");


    // =========================
    // Preferences
    // =========================

    private By newsletter =
            By.id("newsletter");

    private By specialOffers =
            By.id("optin");


    // =========================
    // Address Information
    // =========================

    private By firstName =
            By.id("first_name");

    private By lastName =
            By.id("last_name");

    private By company =
            By.id("company");

    private By address =
            By.id("address1");

    private By address2 =
            By.id("address2");

    private By country =
            By.id("country");

    private By state =
            By.id("state");

    private By city =
            By.id("city");

    private By zipcode =
            By.id("zipcode");

    private By mobileNumber =
            By.id("mobile_number");


    // =========================
    // Create Account
    // =========================

    private By createAccountButton =
            By.cssSelector("[data-qa='create-account']");


    // =========================
    // Constructor
    // =========================

    public AccountInformationPage(WebDriver driver) {
        super(driver);
    }


    // =========================
    // Title
    // =========================

    public void selectMr() {
        clickElement(mrRadioButton);
    }

    public void selectMrs() {
        clickElement(mrsRadioButton);
    }


    // =========================
    // Account Information
    // =========================

    public void enterName(String value) {
        enterInput(name, value);
    }

    public void enterEmail(String value) {
        enterInput(email, value);
    }

    public void enterPassword(String value) {
        enterInput(password, value);
    }


    // =========================
    // Date of Birth
    // =========================

    public void selectDay(String value) {
        Select select = new Select(waitForElement(day));
        select.selectByVisibleText(value);
    }

    public void selectMonth(String value) {
        Select select = new Select(waitForElement(month));
        select.selectByVisibleText(value);
    }

    public void selectYear(String value) {
        Select select = new Select(waitForElement(year));
        select.selectByVisibleText(value);
    }


    // =========================
    // Preferences
    // =========================

    public void selectNewsletter() {
        if (!waitForElement(newsletter).isSelected()) {
            clickElement(newsletter);
        }
    }

    public void selectSpecialOffers() {
        if (!waitForElement(specialOffers).isSelected()) {
            clickElement(specialOffers);
        }
    }


    // =========================
    // Address Information
    // =========================

    public void enterFirstName(String value) {
        enterInput(firstName, value);
    }

    public void enterLastName(String value) {
        enterInput(lastName, value);
    }

    public void enterCompany(String value) {
        enterInput(company, value);
    }

    public void enterAddress(String value) {
        enterInput(address, value);
    }

    public void enterAddress2(String value) {
        enterInput(address2, value);
    }

    public void selectCountry(String value) {
        Select select = new Select(waitForElement(country));
        select.selectByVisibleText(value);
    }

    public void enterState(String value) {
        enterInput(state, value);
    }

    public void enterCity(String value) {
        enterInput(city, value);
    }

    public void enterZipcode(String value) {
        enterInput(zipcode, value);
    }

    public void enterMobileNumber(String value) {
        enterInput(mobileNumber, value);
    }


    // =========================
    // Field Value Verification
    // =========================

    public String getNameValue() {
        return waitForElement(name)
                .getAttribute("value");
    }

    public String getEmailValue() {
        return waitForElement(email)
                .getAttribute("value");
    }

    public String getPasswordValue() {
        return waitForElement(password)
                .getAttribute("value");
    }

    public String getSelectedDay() {
        Select select = new Select(waitForElement(day));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedMonth() {
        Select select = new Select(waitForElement(month));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedYear() {
        Select select = new Select(waitForElement(year));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isNewsletterSelected() {
        return waitForElement(newsletter).isSelected();
    }

    public boolean isSpecialOffersSelected() {
        return waitForElement(specialOffers).isSelected();
    }

    public String getFirstNameValue() {
        return waitForElement(firstName)
                .getAttribute("value");
    }

    public String getLastNameValue() {
        return waitForElement(lastName)
                .getAttribute("value");
    }

    public String getCompanyValue() {
        return waitForElement(company)
                .getAttribute("value");
    }

    public String getAddressValue() {
        return waitForElement(address)
                .getAttribute("value");
    }

    public String getAddress2Value() {
        return waitForElement(address2)
                .getAttribute("value");
    }

    public String getSelectedCountry() {
        Select select = new Select(waitForElement(country));
        return select.getFirstSelectedOption().getText();
    }

    public String getStateValue() {
        return waitForElement(state)
                .getAttribute("value");
    }

    public String getCityValue() {
        return waitForElement(city)
                .getAttribute("value");
    }

    public String getZipcodeValue() {
        return waitForElement(zipcode)
                .getAttribute("value");
    }

    public String getMobileNumberValue() {
        return waitForElement(mobileNumber)
                .getAttribute("value");
    }


    // =========================
    // Complete Account Information
    // =========================

    public AccountInformationPage fillAccountInformation(
            String title,
            String password,
            String dobDay,
            String dobMonth,
            String dobYear,
            String newsletter,
            String specialOffers,
            String firstName,
            String lastName,
            String company,
            String address,
            String address2,
            String country,
            String state,
            String city,
            String zipcode,
            String mobile) {

        // Title
        if (title.equalsIgnoreCase("Mr.")) {
            selectMr();
        } else if (title.equalsIgnoreCase("Mrs.")) {
            selectMrs();
        }

        // Account Information
        enterPassword(password);

        // Date of Birth
        selectDay(dobDay);
        selectMonth(dobMonth);
        selectYear(dobYear);

        // Preferences
        if (newsletter.equalsIgnoreCase("Yes")) {
            selectNewsletter();
        }

        if (specialOffers.equalsIgnoreCase("Yes")) {
            selectSpecialOffers();
        }

        // Address Information
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterAddress(address);
        enterAddress2(address2);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobileNumber(mobile);

        return this;
    }


    // =========================
    // Navigation
    // =========================

    public AccountCreatedPage navigateToAccountCreated() {
        clickElement(createAccountButton);
        return new AccountCreatedPage(driver);
    }
}