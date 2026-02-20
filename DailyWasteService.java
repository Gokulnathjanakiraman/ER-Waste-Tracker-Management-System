package com.erapp23.service;

import com.erapp23.entity.DailyWaste;
import com.erapp23.repository.DailyWasteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyWasteService {

    @Autowired
    private DailyWasteRepository repo;

    public DailyWaste save(DailyWaste waste) {
        return repo.save(waste);
    }

    public List<DailyWaste> getByDate(
            LocalDate start,
            LocalDate end) {

        return repo.findByEntryDateBetween(start, end);
    }

    public List<DailyWaste> getAll() {
        return repo.findAll();
    }
}
