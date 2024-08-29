package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.WateringStatus;

@Repository
public interface WateringStatusRepository extends JpaRepository<WateringStatus, Long> {
    // Custom query methods can be defined here
}
