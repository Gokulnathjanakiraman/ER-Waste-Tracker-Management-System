package com.erapp23.report;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class ExcelGenerator {

    public static ByteArrayInputStream generate(
            String sheetName,
            String[] headers,
            List<String[]> data) {

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet(sheetName);

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            int rowIdx = 1;

            for (String[] rowData : data) {
                Row row = sheet.createRow(rowIdx++);
                for (int i = 0; i < rowData.length; i++) {
                    row.createCell(i).setCellValue(rowData[i]);
                }
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("Excel error");
        }
    }
}
