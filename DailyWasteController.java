package com.erapp23.controller;

import com.erapp23.entity.DailyWaste;
import com.erapp23.repository.DailyWasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DailyWasteController {

    @Autowired
    private DailyWasteRepository wasteRepo;

    @GetMapping("/daily-waste")
    public String dailyWastePage() {
        return "daily_waste";
    }

    @PostMapping("/daily-waste/save")
    public String saveDailyWaste(@RequestParam float incomingDry,
                                 @RequestParam float incomingWet,
                                 @RequestParam float rejectWaste) {

        DailyWaste waste = new DailyWaste();
        waste.setIncomingDry(incomingDry);
        waste.setIncomingWet(incomingWet);
        waste.setRejectWaste(rejectWaste);
        waste.setTotalWaste(incomingDry + incomingWet + rejectWaste);

        wasteRepo.save(waste);
        return "dashboard";
    }
}
