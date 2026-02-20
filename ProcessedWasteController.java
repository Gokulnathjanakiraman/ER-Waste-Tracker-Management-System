package com.erapp23.controller;

import com.erapp23.entity.ProcessedWaste;
import com.erapp23.entity.MaterialMaster;
import com.erapp23.repository.ProcessedWasteRepository;
import com.erapp23.repository.MaterialMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ProcessedWasteController {

    @Autowired
    private ProcessedWasteRepository wasteRepo;

    @Autowired
    private MaterialMasterRepository materialRepo;

    @GetMapping("/processed-waste")
    public String processedWastePage() {
        return "processed_waste";
    }

    // Suggest materials
    @GetMapping("/materials")
    @ResponseBody
    public List<MaterialMaster> getMaterials() {
        return materialRepo.findAll();
    }

    // Save processed waste
    @PostMapping("/processed-waste/save")
    public String saveProcessedWaste(@RequestParam String materialName,
                                     @RequestParam float quantity) {

        LocalDate today = LocalDate.now();

        float total = wasteRepo.findByEntryDate(today)
                .stream()
                .map(ProcessedWaste::getQuantity)
                .reduce(0f, Float::sum) + quantity;

        ProcessedWaste waste = new ProcessedWaste();
        waste.setMaterialName(materialName);
        waste.setQuantity(quantity);
        waste.setTotalQuantity(total);
        waste.setEntryDate(today);   // IMPORTANT

        wasteRepo.save(waste);

        return "redirect:/dashboard";
    }
}