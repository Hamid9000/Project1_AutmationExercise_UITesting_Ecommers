package com.automationExercise.dataprovider;

import com.automationExercise.utils.UtilsExcel;
import org.testng.annotations.DataProvider;

public class SignupDataProvider {

    @DataProvider(name = "signupPositiveData")
    public static Object[][] getPositiveData() {
        return UtilsExcel.getTestDataFromExcel("Signup", "Positive");
    }

    @DataProvider(name = "signupNegativeData")
    public static Object[][] getNegativeData() {
        return UtilsExcel.getTestDataFromExcel("Signup", "Negative");
    }
}