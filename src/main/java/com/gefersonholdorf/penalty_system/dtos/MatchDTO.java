package com.gefersonholdorf.penalty_system.dtos;

import java.time.Instant;

import com.gefersonholdorf.penalty_system.entities.Match;
import com.gefersonholdorf.penalty_system.entities.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    
    private Long id;
    private Instant data;
    private Team homeTeam;
    private Team visitingTeam;
    private String gymnasium;

    public MatchDTO(Match entity) {
        this.id = entity.getId();
        this.data = entity.getData();
        this.homeTeam = entity.getHomeTeam();
        this.visitingTeam = entity.getVisitingTeam();
        this.gymnasium = entity.getHomeTeam().getGymnasium();
    }
}
