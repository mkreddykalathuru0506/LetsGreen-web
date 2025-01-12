package com.letsGreen.service;

import com.letsGreen.entity.UpcomingPlantsReport;
import java.util.List;

public interface UpcomingPlantsReportService {
    UpcomingPlantsReport createUpcomingPlantsReport(UpcomingPlantsReport upcomingPlantsReport);
    UpcomingPlantsReport getUpcomingPlantsReportById(Long plantId);
    List<UpcomingPlantsReport> getAllUpcomingPlantsReports();
    UpcomingPlantsReport updateUpcomingPlantsReport(Long plantId, UpcomingPlantsReport upcomingPlantsReport);
    void deleteUpcomingPlantsReport(Long plantId);
}
