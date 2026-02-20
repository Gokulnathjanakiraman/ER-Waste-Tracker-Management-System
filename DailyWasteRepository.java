package com.erapp23.repository;

import com.erapp23.entity.DailyWaste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DailyWasteRepository
        extends JpaRepository<DailyWaste, Long> {

    List<DailyWaste> findByEntryDateBetween(
            LocalDate start,
            LocalDate end);
}
