package com.erapp23.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfGenerator {

    public static ByteArrayInputStream generate(
            String title,
            String[] headers,
            List<String[]> data) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph(title));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(headers.length);

            for (String header : headers) {
                table.addCell(header);
            }

            for (String[] row : data) {
                for (String cell : row) {
                    table.addCell(cell);
                }
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF");
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
