package com.automationExercise.db;

import com.automationExercise.config.DBConfigLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {

            try {

                Class.forName(
                        DBConfigLoader.get("db.driver")
                );

                connection =
                        DriverManager.getConnection(
                                DBConfigLoader.get("db.url"),
                                DBConfigLoader.get("db.username"),
                                DBConfigLoader.get("db.password")
                        );

                System.out.println(
                        "Database connected successfully."
                );

            } catch (
                    ClassNotFoundException |
                    SQLException e
            ) {

                throw new RuntimeException(
                        "Failed to connect to database",
                        e
                );
            }
        }

        return connection;
    }

    public static void closeConnection() {

        if (connection != null) {

            try {

                connection.close();

                connection = null;

                System.out.println(
                        "Database connection closed."
                );

            } catch (SQLException e) {

                throw new RuntimeException(
                        "Failed to close database connection",
                        e
                );
            }
        }
    }
}