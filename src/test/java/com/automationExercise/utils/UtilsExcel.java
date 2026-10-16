
package com.automationExercise.utils;

import com.automationExercise.config.ConfigLoader;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilsExcel {

    // Step 1: Excel file path
    private static final String SHEET_PATH =
            System.getProperty("user.dir") + "/"
                    + ConfigLoader.get("excel_path");

    // Step 2: Read Excel data and filter by TestType
    public static Object[][] getTestDataFromExcel(
            String sheetName, String testType) {

        try (FileInputStream file = new FileInputStream(SHEET_PATH);
             Workbook book = WorkbookFactory.create(file)) {

            // Step 3: Select the sheet
            Sheet sheet = book.getSheet(sheetName);

            if (sheet == null) {
                throw new IllegalArgumentException(
                        "Sheet not found: " + sheetName);
            }

            // Step 4: Read the header row
            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {
                throw new IllegalArgumentException(
                        "Header row is missing: " + sheetName);
            }

            // Step 5: Find the TestType column
            DataFormatter formatter = new DataFormatter();
            int cols = headerRow.getLastCellNum();
            int testTypeCol = -1;

            for (int j = 0; j < cols; j++) {
                Cell cell = headerRow.getCell(j);

                if (cell != null &&
                        formatter.formatCellValue(cell)
                                .trim().equalsIgnoreCase("TestType")) {
                    testTypeCol = j;
                    break;
                }
            }

            if (testTypeCol == -1) {
                throw new IllegalArgumentException(
                        "TestType column not found in: " + sheetName);
            }

            // Step 6: Filter rows by the requested test type
            List<Object[]> filteredData = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                Cell typeCell = row.getCell(testTypeCol);

                String actualType = typeCell == null
                        ? ""
                        : formatter.formatCellValue(typeCell).trim();

                if (!actualType.equalsIgnoreCase(testType)) {
                    continue;
                }

                // Step 7: Read all columns for matching rows
                Object[] rowData = new Object[cols];

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);

                    rowData[j] = cell == null
                            ? ""
                            : formatter.formatCellValue(cell).trim();
                }

                filteredData.add(rowData);
            }

            // Step 8: Convert List to Object[][]
            return filteredData.toArray(new Object[0][]);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to read Excel file: " + e.getMessage(), e);
        }
    }
}
