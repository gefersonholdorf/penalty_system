package com.gefersonholdorf.penalty_system.dtos;

import com.gefersonholdorf.penalty_system.entities.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertResultDTO {
    
    private Long id;
    private Long match;

    public InsertResultDTO(Result entity) {
        this.id = entity.getId();
        this.match = entity.getMatch().getId();
    }
}
