package com.gefersonholdorf.penalty_system.dtos;

import com.gefersonholdorf.penalty_system.entities.Round;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertRoundDTO {

    private Long id;
    private Long numberRound;
    
    public InsertRoundDTO(Round entity) {
        this.id = entity.getId();
        this.numberRound = entity.getNumberRound().longValue();
    }
}
