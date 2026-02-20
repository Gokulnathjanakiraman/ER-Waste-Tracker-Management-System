package com.erapp23.controller;

import com.erapp23.entity.VehicleEntry;
import com.erapp23.repository.VehicleEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class VehicleEntryController {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private VehicleEntryRepository vehicleRepo;

    @GetMapping("/vehicle-entry/{type}")
    public String vehiclePage(@PathVariable String type) {
        return "vehicle_entry";
    }

    @PostMapping("/vehicle-entry/save")
    public String saveVehicle(@RequestParam String wasteType,
                              @RequestParam String vehicleNumber,
                              @RequestParam MultipartFile photo) throws Exception {

        String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);
        Files.write(path, photo.getBytes());

        VehicleEntry entry = new VehicleEntry();
        entry.setWasteType(wasteType);
        entry.setVehicleNumber(vehicleNumber);
        

        vehicleRepo.save(entry);

        return "dashboard";
    }
}
