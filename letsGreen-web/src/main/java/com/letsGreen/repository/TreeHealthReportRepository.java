package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.TreeHealthReport;

@Repository
public interface TreeHealthReportRepository extends JpaRepository<TreeHealthReport, Long> {
    // Custom query methods can be defined here
}
