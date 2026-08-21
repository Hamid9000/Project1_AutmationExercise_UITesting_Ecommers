package com.automationexercise.driver;

import com.automationExercise.config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {

        String browser = System.getProperty("browser");

        if (browser == null || browser.isEmpty()) {
            browser = ConfigLoader.get("browser");
        }

        String headless = System.getProperty("headless");

        if (headless == null || headless.isEmpty()) {
            headless = ConfigLoader.get("headless");
        }

        browser = browser.toLowerCase();

        WebDriver webDriver;

        switch (browser) {

            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");

                if ("true".equalsIgnoreCase(headless)) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                webDriver = new ChromeDriver(chromeOptions);
                break;

            case "edge":

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");

                if ("true".equalsIgnoreCase(headless)) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--disable-gpu");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }

                webDriver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if ("true".equalsIgnoreCase(headless)) {
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--width=1920");
                    firefoxOptions.addArguments("--height=1080");
                }

                webDriver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.set(webDriver);

        System.out.println(
                "Browser Launched -> " + browser +
                        " | Headless -> " + headless +
                        " | Thread -> " + Thread.currentThread().getId()
        );
    }

    public static void quit() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}