package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsById(String id);
    // Custom query methods can be defined here
}
