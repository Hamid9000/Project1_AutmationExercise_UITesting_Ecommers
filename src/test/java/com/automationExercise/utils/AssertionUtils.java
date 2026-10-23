package com.automationExercise.utils;

import org.testng.asserts.SoftAssert;

public class AssertionUtils {

    private final SoftAssert softAssert = new SoftAssert();

    public void assertTrue(boolean condition, String message) {
        softAssert.assertTrue(condition, message);
    }

    public void assertEquals(Object actual, Object expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}