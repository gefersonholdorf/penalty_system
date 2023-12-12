package com.gefersonholdorf.penalty_system.dtos;

import com.gefersonholdorf.penalty_system.entities.Group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {
    
    private Long id;
    private String name; 

    public GroupDTO(Group entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
