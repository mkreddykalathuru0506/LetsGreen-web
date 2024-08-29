package com.letsGreen.service;

import com.letsGreen.entity.PlantingReport;
import java.util.List;

public interface PlantingReportService {
    PlantingReport createPlantingReport(PlantingReport plantingReport);
    PlantingReport getPlantingReportById(Long id);
    List<PlantingReport> getAllPlantingReports();
    PlantingReport updatePlantingReport(Long id, PlantingReport plantingReport);
    void deletePlantingReport(Long id);
}
