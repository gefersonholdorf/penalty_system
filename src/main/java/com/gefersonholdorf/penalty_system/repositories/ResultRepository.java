package com.gefersonholdorf.penalty_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gefersonholdorf.penalty_system.entities.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long>{
    
}
