package com.gefersonholdorf.penalty_system.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gefersonholdorf.penalty_system.entities.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team_AthleteDTO {

    private Long id;
    private String name;
    private String gymnasium;
    private Double pot;
    private List<AthleteDTO> athletes;

    public Team_AthleteDTO(Team entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.gymnasium = entity.getGymnasium();
        this.pot = entity.getPot();
        this.athletes = entity.getAthletes().stream().map(x -> new AthleteDTO(x)).collect(Collectors.toList());
    }
    
}
