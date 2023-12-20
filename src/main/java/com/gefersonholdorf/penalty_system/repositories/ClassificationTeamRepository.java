package com.gefersonholdorf.penalty_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gefersonholdorf.penalty_system.entities.ClassificationTeam;

@Repository
public interface ClassificationTeamRepository extends JpaRepository<ClassificationTeam, Long>{
    
    @Query("SELECT c FROM ClassificationTeam c ORDER BY c.points DESC, c.ownGoals ASC, c.balance DESC, c.victories DESC")
    List<ClassificationTeam> updateTableClassification();
}
