package com.gefersonholdorf.penalty_system.dtos;

import com.gefersonholdorf.penalty_system.entities.ClassificationTeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassificationTeamDTO {
    
    private Long id;
    private String name;
    private Integer points;
    private Integer balance;
    private Integer victories ;
    private Integer draws;
    private Integer defeats;
    private Integer goalsFor;
    private Integer ownGoals;
    private Integer games;

    public ClassificationTeamDTO(ClassificationTeam entity) {
        this.id = entity.getId();
        this.name = entity.getTeam().getName();
        this.points = entity.getPoints();
        this.balance = entity.getBalance();
        this.victories = entity.getVictories();
        this.draws = entity.getDraws();
        this.defeats = entity.getDefeats();
        this.goalsFor = entity.getGoalsFor();
        this.ownGoals = entity.getOwnGoals();
        this.games = entity.getGames();

    }
}
