package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.MaintenanceSchedule;

@Repository
public interface MaintenanceScheduleRepository extends JpaRepository<MaintenanceSchedule, Long> {
    // Custom query methods can be defined here
}
