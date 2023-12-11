package com.gefersonholdorf.penalty_system.dtos;

import com.gefersonholdorf.penalty_system.entities.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    private Long id;
    private String name;
    private String gymnasium;
    private Double pot;

    public TeamDTO(Team entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.gymnasium = entity.getGymnasium();
        this.pot = entity.getPot();
    }
    
}
