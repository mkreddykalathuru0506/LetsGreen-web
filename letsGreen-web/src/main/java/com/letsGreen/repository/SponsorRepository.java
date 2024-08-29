package com.letsGreen.repository;

import com.letsGreen.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    // You can define custom query methods if needed
}
