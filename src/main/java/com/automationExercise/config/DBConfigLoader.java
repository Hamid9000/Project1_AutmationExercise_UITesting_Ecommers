package com.automationExercise.config;

import com.automationExercise.utils.PropertiesReader;

import java.util.Properties;

public class DBConfigLoader {

    private static final Properties properties =
            new Properties();

    static {
        loadDBConfig();
    }

    private static void loadDBConfig() {

        String environment =
                ConfigLoader.get("environment");

        String fileName;

        if (environment == null ||
                environment.isEmpty()) {

            fileName =
                    "default-db.properties";

        } else {

            fileName =
                    environment + "-db.properties";
        }

        Properties dbProperties =
                PropertiesReader.readProperties(
                        fileName
                );

        properties.putAll(dbProperties);

        System.out.println(
                "DB Configuration Loaded: "
                        + fileName
        );
    }

    public static String get(String key) {

        String value =
                properties.getProperty(key);

        if (value == null) {

            throw new RuntimeException(
                    "DB Key NOT FOUND: " + key
            );
        }

        return value.trim();
    }
}