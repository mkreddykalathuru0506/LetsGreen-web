package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.Decease;

@Repository
public interface DeceaseRepository extends JpaRepository<Decease, Long> {
    // Custom query methods can be defined here
}
