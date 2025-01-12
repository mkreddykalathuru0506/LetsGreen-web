package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.HealthCondition;

@Repository
public interface HealthConditionRepository extends JpaRepository<HealthCondition, Long> {
    // Custom query methods can be defined here
}
