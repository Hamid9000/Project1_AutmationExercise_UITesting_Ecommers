package com.automationExercise.dataprovider;

import com.automationExercise.utils.SQLReader;
import org.testng.annotations.DataProvider;

public class DBTestDataProvider {

    @DataProvider(name = "productData")
    public static Object[][] getProductData() {

        String query =
                SQLReader.get("get_product_by_id");

        return new Object[][]{

                {query, 1},
                {query, 2},
                {query, 3}
        };
    }
}