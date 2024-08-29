package com.letsGreen.repository;

import com.letsGreen.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // You can define custom query methods if needed
}
