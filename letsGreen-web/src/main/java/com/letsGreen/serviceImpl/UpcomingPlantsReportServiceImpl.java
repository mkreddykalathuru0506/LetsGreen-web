package com.letsGreen.serviceImpl;

import com.letsGreen.entity.UpcomingPlantsReport;
import com.letsGreen.repository.UpcomingPlantsReportRepository;
import com.letsGreen.service.UpcomingPlantsReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpcomingPlantsReportServiceImpl implements UpcomingPlantsReportService {

    @Autowired
    private UpcomingPlantsReportRepository upcomingPlantsReportRepository;

    @Override
    public UpcomingPlantsReport createUpcomingPlantsReport(UpcomingPlantsReport upcomingPlantsReport) {
        return upcomingPlantsReportRepository.save(upcomingPlantsReport);
    }

    @Override
    public UpcomingPlantsReport getUpcomingPlantsReportById(Long plantId) {
        return upcomingPlantsReportRepository.findById(plantId).orElse(null);
    }

    @Override
    public List<UpcomingPlantsReport> getAllUpcomingPlantsReports() {
        return upcomingPlantsReportRepository.findAll();
    }

    @Override
    public UpcomingPlantsReport updateUpcomingPlantsReport(Long plantId, UpcomingPlantsReport upcomingPlantsReport) {
		
		  if (upcomingPlantsReportRepository.existsById(plantId)) {
		  upcomingPlantsReport.setPlantId(plantId); return
		  upcomingPlantsReportRepository.save(upcomingPlantsReport); }
		 
        return null;
    }

    @Override
    public void deleteUpcomingPlantsReport(Long plantId) {
        upcomingPlantsReportRepository.deleteById(plantId);
    }
}
