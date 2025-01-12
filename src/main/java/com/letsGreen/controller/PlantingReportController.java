package com.letsGreen.controller;

import com.letsGreen.entity.PlantingReport;
import com.letsGreen.service.PlantingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantingReports")
public class PlantingReportController {

    @Autowired
    private PlantingReportService plantingReportService;

    @PostMapping
    public ResponseEntity<String> createPlantingReport(@RequestBody PlantingReport plantingReport) {
        PlantingReport createdPlantingReport = plantingReportService.createPlantingReport(plantingReport);
        return new ResponseEntity<>("PlantingReport created with ID: " + createdPlantingReport.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPlantingReportById(@PathVariable Long id) {
        PlantingReport plantingReport = plantingReportService.getPlantingReportById(id);
        if (plantingReport != null) {
            return new ResponseEntity<>("PlantingReport found: " + plantingReport.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("PlantingReport not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllPlantingReports() {
        List<PlantingReport> plantingReports = plantingReportService.getAllPlantingReports();
        return new ResponseEntity<>("All PlantingReports: " + plantingReports.toString(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlantingReport(@PathVariable Long id, @RequestBody PlantingReport plantingReport) {
        PlantingReport updatedPlantingReport = plantingReportService.updatePlantingReport(id, plantingReport);
        if (updatedPlantingReport != null) {
            return new ResponseEntity<>("PlantingReport updated: " + updatedPlantingReport.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("PlantingReport not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlantingReport(@PathVariable Long id) {
        plantingReportService.deletePlantingReport(id);
        return new ResponseEntity<>("PlantingReport deleted", HttpStatus.NO_CONTENT);
    }
}
