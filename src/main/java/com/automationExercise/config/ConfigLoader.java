package com.automationExercise.config;

import com.automationExercise.utils.PropertiesReader;

import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties =
            new Properties();

    private static String environment;

    static {
        loadConfig();
    }

    private static void loadConfig() {

        // =========================================
        // 1. Load default.properties
        // =========================================

        Properties defaultProperties =
                PropertiesReader.readProperties(
                        "default.properties"
                );

        properties.putAll(defaultProperties);


        // =========================================
        // 2. Get environment from JVM argument
        // =========================================

        environment =
                System.getProperty("environment");


        // If environment is not provided,
        // take it from default.properties

        if (environment == null ||
                environment.isEmpty()) {

            environment =
                    defaultProperties.getProperty(
                            "environment"
                    );
        }


        // =========================================
        // 3. Validate environment
        // =========================================

        if (environment == null ||
                environment.isEmpty()) {

            throw new RuntimeException(
                    "Environment not found in default.properties"
            );
        }


        // =========================================
        // 4. Load environment-specific properties
        // =========================================
        // Example:
        // qa.properties
        // dev.properties
        // prod.properties

        Properties environmentProperties =
                PropertiesReader.readProperties(
                        environment + ".properties"
                );

        // Environment properties override
        // default properties

        properties.putAll(environmentProperties);


        // =========================================
        // 5. Jenkins / JVM Browser Override
        // =========================================

        String browser =
                System.getProperty("browser");

        if (browser != null &&
                !browser.isEmpty()) {

            properties.setProperty(
                    "browser",
                    browser
            );
        }


        // =========================================
        // 6. Jenkins / JVM Headless Override
        // =========================================

        String headless =
                System.getProperty("headless");

        if (headless != null &&
                !headless.isEmpty()) {

            properties.setProperty(
                    "headless",
                    headless
            );
        }


        // =========================================
        // 7. Store selected environment
        // =========================================

        properties.setProperty(
                "environment",
                environment
        );


        // =========================================
        // 8. Print configuration
        // =========================================

        System.out.println(
                "===================================="
        );

        System.out.println(
                "Running Tests On Environment: "
                        + environment
        );

        System.out.println(
                "Browser: "
                        + properties.getProperty("browser")
        );

        System.out.println(
                "Headless: "
                        + properties.getProperty("headless")
        );

        System.out.println(
                "===================================="
        );
    }


    // =========================================
    // Get configuration value
    // =========================================

    public static String get(String key) {

        String value =
                properties.getProperty(key);

        if (value == null) {

            throw new RuntimeException(
                    "Key NOT FOUND in configuration: "
                            + key
            );
        }

        return value.trim();
    }
}