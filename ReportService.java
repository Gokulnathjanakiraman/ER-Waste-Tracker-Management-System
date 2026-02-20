package com.erapp23.service;

import com.erapp23.entity.Attendance;
import com.erapp23.report.CsvGenerator;
import com.erapp23.report.ExcelGenerator;
import com.erapp23.report.PdfGenerator;
import com.erapp23.repository.AttendanceRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public ByteArrayInputStream generateAttendanceReport(
            String startDate,
            String endDate,
            String type) throws Exception {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<Attendance> records =
                attendanceRepository.findByDateBetween(start, end);

        String[] headers = {
                "Employee ID",
                "Employee Name",
                "Department",
                
                "Date",
                "Status"
        };

        List<String[]> data = new ArrayList<>();

        for (Attendance a : records) {
            data.add(new String[]{
                    a.getEmpId(),
                    a.getEmpName(),
                    a.getDepartment(),
                    a.getDate().toString(),
                    a.getStatus()
            });
        }

        switch (type.toLowerCase()) {
            case "excel":
                return ExcelGenerator.generate("Attendance Report", headers, data);

            case "pdf":
                return PdfGenerator.generate("Attendance Report", headers, data);

            case "csv":
                return CsvGenerator.generate(headers, data);

            default:
                throw new RuntimeException("Invalid report type");
        }
    }
}
