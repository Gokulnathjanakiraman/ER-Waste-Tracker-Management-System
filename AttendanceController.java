package com.erapp23.controller;

import com.erapp23.entity.Attendance;
import com.erapp23.entity.Employee;
import com.erapp23.repository.AttendanceRepository;
import com.erapp23.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AttendanceController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private AttendanceRepository attendanceRepo;

    @GetMapping("/attendance")
    public String attendancePage() {
        return "attendance";
    }

    // AUTO FETCH EMPLOYEE
    @GetMapping("/employee/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable String id) {
        return employeeRepo.findById(id).orElse(null);
    }

    // SAVE ATTENDANCE
    @PostMapping("/attendance/save")
    public String saveAttendance(Attendance attendance) {
        attendanceRepo.save(attendance);
        return "dashboard";
    }
}
