package com.automationExercise.utils;

import com.automationExercise.config.ConfigLoader;

import static io.restassured.RestAssured.given;

public class UserApi {

    public static boolean deleteUser(String email, String password) {

        String baseUrl =
                ConfigLoader.get("base_url");

        String endpoint =
                ConfigLoader.get("delete_account_endpoint");

        int statusCode =
                given()
                        .baseUri(baseUrl)
                        .formParam("email", email)
                        .formParam("password", password)

                        .when()
                        .delete(endpoint)

                        .then()
                        .extract()
                        .statusCode();

        return statusCode == 200;
    }
}