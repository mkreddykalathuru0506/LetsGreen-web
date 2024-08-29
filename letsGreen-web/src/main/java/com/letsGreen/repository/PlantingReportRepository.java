package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.PlantingReport;

@Repository
public interface PlantingReportRepository extends JpaRepository<PlantingReport, Long> {
    // Custom query methods can be defined here
}
