package com.erapp23.service;

import com.erapp23.entity.DailyActivity;
import com.erapp23.repository.DailyActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyActivityService {

    @Autowired
    private DailyActivityRepository repo;

    public DailyActivity save(DailyActivity activity) {
        return repo.save(activity);
    }
}
