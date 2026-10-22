package com.automationExercise.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties readProperties(String fileName) {

        Properties properties = new Properties();

        try (InputStream inputStream =
                     PropertiesReader.class
                             .getClassLoader()
                             .getResourceAsStream("config/" + fileName)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        fileName + " not found inside resources/config"
                );
            }

            properties.load(inputStream);

            return properties;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read properties file: " + fileName, e
            );
        }
    }
}