package com.gefersonholdorf.penalty_system.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.MatchDTO;
import com.gefersonholdorf.penalty_system.entities.Group;
import com.gefersonholdorf.penalty_system.entities.Match;
import com.gefersonholdorf.penalty_system.repositories.GroupRepository;
import com.gefersonholdorf.penalty_system.repositories.MatchRepository;
import com.gefersonholdorf.penalty_system.services.exceptions.ResourceNotFoundException;

@Service
public class MatchService {
    
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Transactional(readOnly = true)
    public List<MatchDTO> findAll() {
        List<Match> list = matchRepository.findAll();
        return list.stream().map(x -> new MatchDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true) 
    public MatchDTO findById(Long id) {
        Optional<Match> obj = matchRepository.findById(id);
        Match entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
        return new MatchDTO(entity);
    }

    @Transactional(readOnly = true) 
    public List<MatchDTO> findByGroup(Long id) {
        Optional<Group> obj = groupRepository.findById(id);
        Group entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
        List<Match> list = matchRepository.findAll();
        List<Match> newList = list.stream().filter(x -> x.getGroup().getId() == entity.getId()).collect(Collectors.toList());
        return newList.stream().map(x -> new MatchDTO(x)).collect(Collectors.toList());
    }
}
