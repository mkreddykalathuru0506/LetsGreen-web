package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.UpcomingPlantsReport;

@Repository
public interface UpcomingPlantsReportRepository extends JpaRepository<UpcomingPlantsReport, Long> {
    // Custom query methods can be defined here
}
