
package com.automationExercise.pages;

import com.automationExercise.base.CommonToAllPage;
import com.automationExercise.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage extends CommonToAllPage {

    // =========================
    // Title
    // =========================

    private final By mrRadioButton = By.id("id_gender1");
    private final By mrsRadioButton = By.id("id_gender2");

    // =========================
    // Account Information
    // =========================

    private final By name = By.id("name");
    private final By email = By.id("email");
    private final By password = By.id("password");

    // =========================
    // Date of Birth
    // =========================

    private final By day = By.id("days");
    private final By month = By.id("months");
    private final By year = By.id("years");

    // =========================
    // Preferences
    // =========================

    private final By newsletter = By.id("newsletter");
    private final By specialOffers = By.id("optin");

    // =========================
    // Address Information
    // =========================

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address = By.id("address1");
    private final By address2 = By.id("address2");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");

    // =========================
    // Create Account
    // =========================

    private final By createAccountButton =
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
        waitUtils.waitForElementClickable(mrRadioButton).click();
    }

    public void selectMrs() {
        waitUtils.waitForElementClickable(mrsRadioButton).click();
    }

    // =========================
    // Account Information
    // =========================

    public void enterName(String value) {
        enter(name, value);
    }

    public void enterEmail(String value) {
        enter(email, value);
    }

    public void enterPassword(String value) {
        enter(password, value);
    }

    // =========================
    // Date of Birth
    // =========================

    public void selectDay(String value) {
        selectDropdownByText(day, value);
    }

    public void selectMonth(String value) {
        selectDropdownByText(month, value);
    }

    public void selectYear(String value) {
        selectDropdownByText(year, value);
    }

    // =========================
    // Preferences
    // =========================

    public void selectNewsletter() {
        if (!waitUtils.waitForElementVisible(newsletter).isSelected()) {
            click(newsletter);
        }
    }

    public void selectSpecialOffers() {
        if (!waitUtils.waitForElementVisible(specialOffers).isSelected()) {
            click(specialOffers);
        }
    }

    // =========================
    // Address Information
    // =========================

    public void enterFirstName(String value) {
        enter(firstName, value);
    }

    public void enterLastName(String value) {
        enter(lastName, value);
    }

    public void enterCompany(String value) {
        enter(company, value);
    }

    public void enterAddress(String value) {
        enter(address, value);
    }

    public void enterAddress2(String value) {
        enter(address2, value);
    }

    public void selectCountry(String value) {
        selectDropdownByText(country, value);
    }

    public void enterState(String value) {
        enter(state, value);
    }

    public void enterCity(String value) {
        enter(city, value);
    }

    public void enterZipcode(String value) {
        enter(zipcode, value);
    }

    public void enterMobileNumber(String value) {
        enter(mobileNumber, value);
    }
    public void setNewsletter(boolean shouldSelect) {
        boolean isSelected =
                waitUtils.waitForElementVisible(newsletter).isSelected();

        if (shouldSelect != isSelected) {
            click(newsletter);
        }
    }


    public void setSpecialOffers(boolean shouldSelect) {
        boolean isSelected =
                waitUtils.waitForElementVisible(specialOffers).isSelected();

        if (shouldSelect != isSelected) {
            click(specialOffers);
        }
    }
    // =========================
    // Field Value Verification
    // =========================

    public String getNameValue() {
        return waitUtils.waitForElementVisible(name).getAttribute("value");
    }

    public String getEmailValue() {
        return waitUtils.waitForElementVisible(email).getAttribute("value");
    }

    public String getPasswordValue() {
        return waitUtils.waitForElementVisible(password).getAttribute("value");
    }

    public String getSelectedDay() {
        return new Select(waitUtils.waitForElementVisible(day)).getFirstSelectedOption().getText();
    }

    public String getSelectedMonth() {
        return new Select(waitUtils.waitForElementVisible(month)).getFirstSelectedOption().getText();
    }

    public String getSelectedYear() {
        return new Select(waitUtils.waitForElementVisible(year)).getFirstSelectedOption().getText();

    }

    public boolean isNewsletterSelected() {
        return waitUtils.waitForElementVisible(newsletter).isSelected();
    }

    public boolean isSpecialOffersSelected() {
        return waitUtils.waitForElementVisible(specialOffers).isSelected();
    }

    public String getFirstNameValue() {
        return waitUtils.waitForElementVisible(firstName).getAttribute("value");
    }

    public String getLastNameValue() {
        return waitUtils.waitForElementVisible(lastName).getAttribute("value");
    }

    public String getCompanyValue() {
        return waitUtils.waitForElementVisible(company).getAttribute("value");
    }

    public String getAddressValue() {
        return waitUtils.waitForElementVisible(address).getAttribute("value");
    }

    public String getAddress2Value() {
        return waitUtils.waitForElementVisible(address2).getAttribute("value");
    }

    public String getSelectedCountry() {
        return new Select(waitUtils.waitForElementVisible(country)).getFirstSelectedOption().getText();
    }

    public String getStateValue() {
        return waitUtils.waitForElementVisible(state).getAttribute("value");
    }

    public String getCityValue() {
        return waitUtils.waitForElementVisible(city).getAttribute("value");
    }

    public String getZipcodeValue() {
        return waitUtils.waitForElementVisible(zipcode).getAttribute("value");
    }

    public String getMobileNumberValue() {
        return waitUtils.waitForElementVisible(mobileNumber).getAttribute("value");
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
        if ("Mr.".equalsIgnoreCase(title)) {
            selectMr();
        } else if ("Mrs.".equalsIgnoreCase(title)) {
            selectMrs();
        } else {
            throw new IllegalArgumentException("Invalid title: " + title);
        }
        // Account Information
        enterPassword(password);

        // Date of Birth
        selectDay(dobDay);
        selectMonth(dobMonth);
        selectYear(dobYear);

        // Preferences


        setNewsletter("Yes".equalsIgnoreCase(newsletter));
        setSpecialOffers("Yes".equalsIgnoreCase(specialOffers));

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

        waitUtils.waitForFixTime(1000);
        return this;
    }

    // =========================
    // Navigation
    // =========================

    public AccountCreatedPage clickOnCreateAccount() {
        clickWithWait(createAccountButton);
        return new AccountCreatedPage(driver);
    }
}
