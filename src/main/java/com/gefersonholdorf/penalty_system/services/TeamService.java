package com.gefersonholdorf.penalty_system.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.TeamDTO;
import com.gefersonholdorf.penalty_system.dtos.Team_AthleteDTO;
import com.gefersonholdorf.penalty_system.entities.Team;
import com.gefersonholdorf.penalty_system.repositories.TeamRepository;
import com.gefersonholdorf.penalty_system.services.exceptions.ResourceNotFoundException;

@Service
public class TeamService {
    
    @Autowired
    private TeamRepository teamRepository;

    @Transactional(readOnly = true)
    public List<TeamDTO> findAll() {
        List<Team> list = teamRepository.findAll();
        return list.stream().map(x -> new TeamDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Team_AthleteDTO findById(Long id) {
        Optional<Team> obj = teamRepository.findById(id);
        Team entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
        return new Team_AthleteDTO(entity);
    }
}
