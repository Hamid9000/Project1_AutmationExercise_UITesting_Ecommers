package com.automationExercise.dataprovider;

import com.automationExercise.utils.UtilsExcel;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginValidData")
    public static Object[][] getValidLoginData() {

        return UtilsExcel.getTestDataFromExcel("Login_Valid");
    }

    @DataProvider(name = "loginInvalidData")
    public static Object[][] getInvalidLoginData() {

        return UtilsExcel.getTestDataFromExcel("Login_Invalid");
    }
}