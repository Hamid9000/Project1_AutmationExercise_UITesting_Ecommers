package com.automationExercise.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilsExcel {

    public static final String SHEET_PATH = System.getProperty("user.dir") + "/" + PropertiesReader.readKeys("excel_path");

    // Generic method to read Excel data from given sheet
    public static Object[][] getTestDataFromExcel(String sheetName) {
        try (FileInputStream file = new FileInputStream(SHEET_PATH);
             Workbook book = WorkbookFactory.create(file)) {

            Sheet sheet = book.getSheet(sheetName);

            int rows = sheet.getLastRowNum(); // excluding header
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = (sheet.getRow(i + 1).getCell(j) == null) ? "" :
                            sheet.getRow(i + 1).getCell(j).toString().trim();
                }
            }
            return data;

        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + e.getMessage(), e);
        }
    }

    @DataProvider(name = "validData")
    public static Object[][] getValidData() {
        return getTestDataFromExcel("valid");
    }

    @DataProvider(name = "inValidData")
    public static Object[][] getInvalidData() {
        return getTestDataFromExcel("invalid");
    }
}
