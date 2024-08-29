package com.letsGreen.controller;

import com.letsGreen.entity.UpcomingPlantsReport;
import com.letsGreen.service.UpcomingPlantsReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upcomingPlantsReports")
public class UpcomingPlantsReportController {

    @Autowired
    private UpcomingPlantsReportService upcomingPlantsReportService;

    @PostMapping
    public ResponseEntity<String> createUpcomingPlantsReport(@RequestBody UpcomingPlantsReport upcomingPlantsReport) {
        UpcomingPlantsReport createdUpcomingPlantsReport = upcomingPlantsReportService.createUpcomingPlantsReport(upcomingPlantsReport);
        return new ResponseEntity<>("UpcomingPlantsReport created with Plant ID: " + createdUpcomingPlantsReport.getPlantId(), HttpStatus.CREATED);
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<String> getUpcomingPlantsReportById(@PathVariable Long plantId) {
        UpcomingPlantsReport upcomingPlantsReport = upcomingPlantsReportService.getUpcomingPlantsReportById(plantId);
        if (upcomingPlantsReport != null) {
            return new ResponseEntity<>("UpcomingPlantsReport found: " + upcomingPlantsReport.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("UpcomingPlantsReport not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllUpcomingPlantsReports() {
        List<UpcomingPlantsReport> upcomingPlantsReports = upcomingPlantsReportService.getAllUpcomingPlantsReports();
        return new ResponseEntity<>("All UpcomingPlantsReports: " + upcomingPlantsReports.toString(), HttpStatus.OK);
    }

    @PutMapping("/{plantId}")
    public ResponseEntity<String> updateUpcomingPlantsReport(@PathVariable Long plantId, @RequestBody UpcomingPlantsReport upcomingPlantsReport) {
        UpcomingPlantsReport updatedUpcomingPlantsReport = upcomingPlantsReportService.updateUpcomingPlantsReport(plantId, upcomingPlantsReport);
        if (updatedUpcomingPlantsReport != null) {
            return new ResponseEntity<>("UpcomingPlantsReport updated: " + updatedUpcomingPlantsReport.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("UpcomingPlantsReport not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{plantId}")
    public ResponseEntity<String> deleteUpcomingPlantsReport(@PathVariable Long plantId) {
        upcomingPlantsReportService.deleteUpcomingPlantsReport(plantId);
        return new ResponseEntity<>("UpcomingPlantsReport deleted", HttpStatus.NO_CONTENT);
    }
}
