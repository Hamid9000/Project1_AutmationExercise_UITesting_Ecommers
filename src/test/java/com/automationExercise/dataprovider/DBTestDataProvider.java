package com.automationExercise.dataprovider;

import org.testng.annotations.DataProvider;

public class DBTestDataProvider {
    @DataProvider(name = "productData")
    public static Object[][] getProductData() {

        return new Object[][]{
                {"SELECT * FROM products WHERE id = ?", 1},
                {"SELECT * FROM products WHERE id = ?", 2},
                {"SELECT * FROM products WHERE id = ?", 3}
        };
    }
}
