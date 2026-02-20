package com.erapp23.repository;

import com.erapp23.entity.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DailyActivityRepository
        extends JpaRepository<DailyActivity, Long> {

	List<DailyActivity> findByActivityDateBetween(LocalDate start, LocalDate end);

}
