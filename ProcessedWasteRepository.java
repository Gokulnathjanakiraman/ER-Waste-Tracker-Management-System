package com.erapp23.repository;

import com.erapp23.entity.ProcessedWaste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProcessedWasteRepository
        extends JpaRepository<ProcessedWaste, Long> {

    List<ProcessedWaste> findByEntryDate(LocalDate entryDate);
}
