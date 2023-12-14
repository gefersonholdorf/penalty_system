package com.gefersonholdorf.penalty_system.dtos;

import com.gefersonholdorf.penalty_system.entities.Athlete;
import com.gefersonholdorf.penalty_system.enums.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AthleteDTO {
    
    private Long id;
    private String name;
    private Double pot;
    private Double hab;
    private Position position;
    private Long teamId;

    public AthleteDTO(Athlete entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pot = entity.getPot();
        this.hab = entity.getHab();
        this.position = entity.getPosition();
        this.teamId = entity.getTeam().getId();
    }
}
