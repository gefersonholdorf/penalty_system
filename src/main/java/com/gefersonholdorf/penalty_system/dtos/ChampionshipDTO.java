package com.gefersonholdorf.penalty_system.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gefersonholdorf.penalty_system.entities.Championship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampionshipDTO {
    
    private Long id;
    private String name;
    private List<GroupDTO> groupsDTO;
    private FinalPhaseDTO finalPhaseDTO;

    public ChampionshipDTO(Championship entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.groupsDTO = entity.getGroups().stream().map(x -> new GroupDTO(x)).collect(Collectors.toList());
        this.finalPhaseDTO = new FinalPhaseDTO(entity.getFinalPhase());
    }
}
