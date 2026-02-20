package com.erapp23.controller;

import com.erapp23.entity.DailyActivity;
import com.erapp23.repository.DailyActivityRepository;
import com.erapp23.service.DailyActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DailyActivityController {

    @Autowired
    private DailyActivityRepository activityRepo;

    @GetMapping("/activity")
    public String activityPage() {
        return "activity";
    }
    @Autowired
    private DailyActivityService service;

    @PostMapping("/save")
    public DailyActivity save(
            @RequestBody DailyActivity a) {
        return service.save(a);
    }


    @PostMapping("/activity/save")
    public String saveActivity(@RequestParam String activityDescription) {

        DailyActivity activity = new DailyActivity();
        activity.setActivityDescription(activityDescription);

        activityRepo.save(activity);
        return "dashboard";
    }
}
