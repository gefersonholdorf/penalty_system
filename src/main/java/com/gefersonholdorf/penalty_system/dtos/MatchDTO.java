package com.gefersonholdorf.penalty_system.dtos;

import java.time.Instant;

import com.gefersonholdorf.penalty_system.entities.Match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    
    private Long id;
    private Instant data;
    private String gymnasium;
    private String homeTeam;
    private String visitingTeam;
    private Integer round;
    private Long groupId;

    public MatchDTO(Match entity) {
        this.id = entity.getId();
        this.data = entity.getData();
        this.gymnasium = entity.getHomeTeam().getGymnasium();
        this.homeTeam = entity.getHomeTeam().getName();
        this.visitingTeam = entity.getVisitingTeam().getName();
        this.round = entity.getRound().getNumberRound();
        this.groupId = entity.getGroup().getId();
    }
}
