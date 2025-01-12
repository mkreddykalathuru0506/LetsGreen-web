package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.Nursery;

@Repository
public interface NurseryRepository extends JpaRepository<Nursery, Long> {
    // Custom query methods can be defined here
}
