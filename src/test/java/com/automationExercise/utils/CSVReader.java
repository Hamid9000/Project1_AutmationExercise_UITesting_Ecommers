package com.automationExercise.utils;

import com.automationExercise.config.ConfigLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private CSVReader() {
    }

    public static Object[][] getData() {

        String csvPath = ConfigLoader.get("csv_path");

        List<Object[]> data = new ArrayList<>();

        try (InputStream inputStream =
                     CSVReader.class.getClassLoader()
                             .getResourceAsStream(csvPath)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "CSV file not found: " + csvPath
                );
            }

            try (BufferedReader br =
                         new BufferedReader(new InputStreamReader(inputStream))) {

                String line;
                boolean isHeader = true;

                while ((line = br.readLine()) != null) {

                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }

                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    String[] values = line.split(",", -1);
                    data.add(values);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read CSV file: " + csvPath, e
            );
        }

        return data.toArray(new Object[0][]);
    }
}