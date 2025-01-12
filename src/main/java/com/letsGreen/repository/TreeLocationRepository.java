package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.TreeLocation;

@Repository
public interface TreeLocationRepository extends JpaRepository<TreeLocation, Long> {
    // Custom query methods can be defined here
}
