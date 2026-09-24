package com.automationExercise.dataprovider;

import com.automationExercise.utils.CSVReader;
import com.automationExercise.utils.UtilsExcel;
import org.testng.annotations.DataProvider;

public class SignupDataProvider {

    @DataProvider(name = "signupValidData")
    public static Object[][] getValidSignupData() {

        return UtilsExcel.getTestDataFromExcel("Signup_Valid");
    }

    @DataProvider(name = "signupInvalidData")
    public static Object[][] getInvalidSignupData() {

        return UtilsExcel.getTestDataFromExcel("Signup_Invalid");
    }
    @DataProvider(name = "signupCSVData")
    public static Object[][] getSignupCSVData() {

        return CSVReader.getData();
    }
}