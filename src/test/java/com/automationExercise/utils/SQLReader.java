package com.automationExercise.utils;

import java.util.Properties;

public class SQLReader {

    private static final Properties queries =
            new Properties();

    static {

        Properties sqlProperties =
                PropertiesReader.readProperties(
                        "sql/sql-queries.properties"
                );

        queries.putAll(sqlProperties);
    }

    public static String get(String key) {

        String query =
                queries.getProperty(key);

        if (query == null) {

            throw new RuntimeException(
                    "SQL Query NOT FOUND: " + key
            );
        }

        return query.trim();
    }
}