package com.automationExercise.test.practice.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Practice_BrokenLink {
    @Test
    public void verifyBrokenLink(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/broken");

            List<WebElement> links = driver.findElements(By.tagName("a"));

            for (WebElement link : links){
                String url = link.getAttribute("href");

                if (url == null || url.isEmpty()){
                    System.out.println("skip empty url");
                    continue;
                }

                HttpURLConnection connection = null;
                try {
                    connection = (HttpURLConnection)  new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);

                    connection.connect();

                    int statusCode = connection.getResponseCode();

                    if (statusCode>= 400){
                        System.out.println( url + " | Link is broken | Status: "
                                + statusCode);
                    }else {
                        System.out.println(url + " | Link is working | Status: "
                                + statusCode);
                    }
                }catch (Exception e){
                    System.out.println(url + " | Unable to verify: "
                            + e.getMessage());
                }finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }

            }
        }finally {
            driver.quit();
        }
    }
}
