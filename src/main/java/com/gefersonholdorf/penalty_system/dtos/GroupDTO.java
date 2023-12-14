package com.gefersonholdorf.penalty_system.dtos;

import java.util.List;
import java.util.stream.Collectors;

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
    private List<String> teams;

    public GroupDTO(Group entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.teams = entity.getTeams().stream().map(x -> x.getName()).collect(Collectors.toList());
    }
}
