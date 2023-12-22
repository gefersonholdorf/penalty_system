package com.gefersonholdorf.penalty_system.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gefersonholdorf.penalty_system.entities.Round;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundDTO {
    
    private Long id;
    private String numberRound;
    private String group;
    private List<MatchDTO> rounds;

    public RoundDTO(Round entity) {
        this.id = entity.getId();
        this.numberRound = entity.getNumberRound();
        this.group = entity.getGroup().getName();
        this.rounds = entity.getMatches().stream().map(x -> new MatchDTO(x)).collect(Collectors.toList());
    }
}
