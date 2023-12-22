package com.gefersonholdorf.penalty_system.dtos;

import java.time.Instant;

import com.gefersonholdorf.penalty_system.entities.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    
    private Long id;
    private Long match;
    private Instant data;
    private String gymnasium;
    private Integer homeTeamGoals;
    private Integer visitingTeamGoals;
    private String homeTeam;
    private String visitingTeam;
    private String round;
    private Long groupId;

     public ResultDTO(Result entity) {
        this.id = entity.getId();
        this.match = entity.getMatch().getId();
        this.data = entity.getMatch().getData();
        this.gymnasium = entity.getMatch().getHomeTeam().getGymnasium();
        this.homeTeam = entity.getMatch().getHomeTeam().getName();
        this.homeTeamGoals = entity.getHomeTeamGoals();
        this.visitingTeamGoals = entity.getVisitingTeamGoals();
        this.visitingTeam = entity.getMatch().getVisitingTeam().getName();
        this.round = entity.getMatch().getRound().getNumberRound();
        this.groupId = entity.getMatch().getGroup().getId();
    }
}
