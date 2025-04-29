package com.automationexercise.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXlsData {

    @DataProvider(name = "testdata")
    public Object[][] getData(Method m) throws EncryptedDocumentException, IOException {
        String excelSheetName = m.getName(); // Sheet name must match method name
        File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);

        if (sheetName == null || sheetName.getRow(0) == null) {
            throw new RuntimeException("Excel sheet '" + excelSheetName + "' is empty or not found!");
        }

        int totalRows = sheetName.getLastRowNum();
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();

        DataFormatter format = new DataFormatter();
        Object[][] testData = new Object[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j)).trim();
                System.out.println("Excel Data [" + (i - 1) + "][" + j + "]: " + testData[i - 1][j]);
            }
        }
        wb.close();
        return testData;
    }
}
