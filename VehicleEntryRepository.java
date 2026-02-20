package com.erapp23.repository;

import com.erapp23.entity.VehicleEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VehicleEntryRepository extends JpaRepository<VehicleEntry, Long> {

    List<VehicleEntry> findByEntryDateBetween(LocalDate startDate, LocalDate endDate);

}
