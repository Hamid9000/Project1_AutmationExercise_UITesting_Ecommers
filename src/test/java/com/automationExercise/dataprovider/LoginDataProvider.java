
package com.automationExercise.dataprovider;

import com.automationExercise.utils.UtilsExcel;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    // Provide only Positive login test data
    @DataProvider(name = "loginValidData")
    public static Object[][] getValidLoginData() {
        return UtilsExcel.getTestDataFromExcel("Login", "Positive");
    }

    // Provide only Negative login test data
    @DataProvider(name = "loginInvalidData")
    public static Object[][] getInvalidLoginData() {
        return UtilsExcel.getTestDataFromExcel("Login", "Negative");
    }
}
