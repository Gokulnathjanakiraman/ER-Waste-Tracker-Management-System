package com.erapp23.repository;

import com.erapp23.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByDateBetween(LocalDate start, LocalDate end);

}
