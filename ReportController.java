package com.erapp23.controller;

import com.erapp23.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public String reportPage() {
        return "report";   // report.html
    }

    @PostMapping("/report/generate")
    public ResponseEntity<InputStreamResource> generateReport(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String type) throws Exception {

        ByteArrayInputStream in =
                reportService.generateAttendanceReport(startDate, endDate, type);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename=attendance_report." + type);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
