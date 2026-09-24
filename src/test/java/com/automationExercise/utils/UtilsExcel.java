package com.automationExercise.utils;

import com.automationExercise.config.ConfigLoader;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilsExcel {

    public static final String SHEET_PATH =
            System.getProperty("user.dir") + "/" +
                    ConfigLoader.get("excel_path");

    // Generic method to read Excel data from given sheet
    public static Object[][] getTestDataFromExcel(String sheetName) {

        try (FileInputStream file = new FileInputStream(SHEET_PATH);
             Workbook book = WorkbookFactory.create(file)) {

            Sheet sheet = book.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {
                throw new RuntimeException(
                        "Header row is missing in Excel sheet: " + sheetName
                );
            }

            int rows = sheet.getLastRowNum();

            // Find the last actual non-empty header cell
            int cols = 0;

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {

                if (headerRow.getCell(i) != null &&
                        !headerRow.getCell(i).toString().trim().isEmpty()) {

                    cols = i + 1;
                }
            }

            Object[][] data = new Object[rows][cols];

            DataFormatter formatter = new DataFormatter();

            for (int i = 0; i < rows; i++) {

                Row row = sheet.getRow(i + 1);

                for (int j = 0; j < cols; j++) {

                    if (row == null || row.getCell(j) == null) {

                        data[i][j] = "";

                    } else {

                        data[i][j] =
                                formatter
                                        .formatCellValue(row.getCell(j))
                                        .trim();
                    }
                }
            }

            return data;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to read Excel file: " + e.getMessage(),
                    e
            );
        }
    }
}