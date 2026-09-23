package com.automationExercise.config;

import com.automationExercise.utils.PropertiesReader;

import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    private static String environment;

    static {
        loadConfig();
    }

    private static void loadConfig() {

        // Load default.properties
        Properties defaultProperties =
                PropertiesReader.readProperties("default.properties");

        // Add default properties
        properties.putAll(defaultProperties);

        // Get environment from JVM argument
        environment = System.getProperty("environment");

        // If not provided, take environment from default.properties
        if (environment == null || environment.isEmpty()) {
            environment = defaultProperties.getProperty("environment");
        }

        if (environment == null || environment.isEmpty()) {
            throw new RuntimeException(
                    "environment not found in default.properties"
            );
        }

        System.out.println("====================================");
        System.out.println(
                "Running Tests On Environment: " + environment
        );
        System.out.println("====================================");

        // Load environment-specific properties
        Properties environmentProperties =
                PropertiesReader.readProperties(
                        environment + ".properties"
                );

        // Environment properties override default properties
        properties.putAll(environmentProperties);
    }

    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Key NOT FOUND in configuration: " + key
            );
        }

        return value.trim();
    }
}