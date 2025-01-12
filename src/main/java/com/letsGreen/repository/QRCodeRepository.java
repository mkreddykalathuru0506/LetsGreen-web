package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.QRCode;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    // Custom query methods can be defined here
}
