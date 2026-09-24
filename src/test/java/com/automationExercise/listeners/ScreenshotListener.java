package com.automationExercise.listeners;

import com.automationExercise.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        // Screenshot only after all retries are exhausted
        if (!RetryAnalyzer.isFinalFailure()) {
            return;
        }

        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            System.err.println(
                    "WebDriver is null. Screenshot could not be captured for: "
                            + result.getMethod().getMethodName()
            );

            RetryAnalyzer.clearFinalFailure();
            return;
        }

        String testName =
                result.getMethod().getMethodName();

        try {

            attachScreenshot(driver);

            saveScreenshotToFolder(
                    driver,
                    "Failure_" + testName
            );

            System.out.println(
                    "Final failure screenshot captured for: "
                            + testName
            );

        } catch (Exception e) {

            System.err.println(
                    "Failed to capture failure screenshot: "
                            + e.getMessage()
            );

        } finally {

            RetryAnalyzer.clearFinalFailure();
        }
    }

    @Attachment(
            value = "Final Failure Screenshot",
            type = "image/png"
    )
    public static byte[] attachScreenshot(WebDriver driver) {

        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }

    private void saveScreenshotToFolder(
            WebDriver driver,
            String label) {

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        File screenshotFolder =
                new File("screenshots");

        File destination =
                new File(
                        screenshotFolder,
                        label + "_" + timestamp + ".png"
                );

        try {

            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdirs();
            }

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {

            System.err.println(
                    "Failed to save screenshot: "
                            + e.getMessage()
            );
        }
    }
}