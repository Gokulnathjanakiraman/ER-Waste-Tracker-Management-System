package com.erapp23.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class CsvGenerator {

    public static ByteArrayInputStream generate(
            String[] headers,
            List<String[]> data) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);

        // Header
        writer.println(String.join(",", headers));

        // Data
        for (String[] row : data) {
            writer.println(String.join(",", row));
        }

        writer.flush();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
