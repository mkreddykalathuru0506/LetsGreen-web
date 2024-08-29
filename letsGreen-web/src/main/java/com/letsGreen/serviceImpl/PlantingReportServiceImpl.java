package com.letsGreen.serviceImpl;

import com.letsGreen.entity.PlantingReport;
import com.letsGreen.repository.PlantingReportRepository;
import com.letsGreen.service.PlantingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantingReportServiceImpl implements PlantingReportService {

    @Autowired
    private PlantingReportRepository plantingReportRepository;

    @Override
    public PlantingReport createPlantingReport(PlantingReport plantingReport) {
        return plantingReportRepository.save(plantingReport);
    }

    @Override
    public PlantingReport getPlantingReportById(Long id) {
        return plantingReportRepository.findById(id).orElse(null);
    }

    @Override
    public List<PlantingReport> getAllPlantingReports() {
        return plantingReportRepository.findAll();
    }

    @Override
    public PlantingReport updatePlantingReport(Long id, PlantingReport plantingReport) {
        if (plantingReportRepository.existsById(id)) {
            plantingReport.setId(id);
            return plantingReportRepository.save(plantingReport);
        }
        return null;
    }

    @Override
    public void deletePlantingReport(Long id) {
        plantingReportRepository.deleteById(id);
    }
}
