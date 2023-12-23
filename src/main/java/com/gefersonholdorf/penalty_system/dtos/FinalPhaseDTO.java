package com.gefersonholdorf.penalty_system.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gefersonholdorf.penalty_system.entities.FinalPhase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalPhaseDTO {
    
    private Long id;
    private String name;
    private List<String> listTeams = new ArrayList<>();

    public FinalPhaseDTO(FinalPhase entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.listTeams = entity.getTeams().stream().map(x -> x.getName()).collect(Collectors.toList());
    }
}
