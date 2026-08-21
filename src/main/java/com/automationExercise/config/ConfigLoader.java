package com.automationExercise.config;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();
    private static String env;

    static {
        loadConfig();
    }

    private static void loadConfig() {

        try {

            // ===== STEP 1 : Load default.properties =====
            Properties defaultProp = new Properties();

            try (InputStream defaultFile =
                         ConfigLoader.class.getClassLoader()
                                 .getResourceAsStream("config/default.properties")) {

                if (defaultFile == null) {
                    throw new RuntimeException("default.properties not found inside resources/config");
                }

                defaultProp.load(defaultFile);
            }

            // ===== STEP 2 : Decide ENV (Jenkins override) =====
            env = System.getProperty("env");

            if (env == null || env.isEmpty()) {
                env = defaultProp.getProperty("env");
            }

            System.out.println("====================================");
            System.out.println("Running Tests On Environment: " + env);
            System.out.println("====================================");

            // ===== STEP 3 : Load ENV file =====
            try (InputStream envFile =
                         ConfigLoader.class.getClassLoader()
                                 .getResourceAsStream("config/" + env + ".properties")) {

                if (envFile == null) {
                    throw new RuntimeException(env + ".properties NOT FOUND inside resources/config");
                }

                properties.load(envFile);
            }

        } catch (Exception e) {
            throw new RuntimeException("FAILED TO LOAD CONFIGURATION FILES", e);
        }
    }

    // ===== Get property =====
    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Key NOT FOUND in " + env + ".properties : " + key);
        }

        return value.trim();
    }
}