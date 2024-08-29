package com.letsGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letsGreen.entity.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
    // Custom query methods can be defined here
}
