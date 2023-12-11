package com.gefersonholdorf.penalty_system.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.AthleteDTO;
import com.gefersonholdorf.penalty_system.entities.Athlete;
import com.gefersonholdorf.penalty_system.repositories.AthleteRepository;
import com.gefersonholdorf.penalty_system.services.exceptions.ResourceNotFoundException;

@Service
public class AthleteService {
    
    @Autowired
    private AthleteRepository athleteRepository;

    @Transactional(readOnly = true)
    public List<AthleteDTO> findAll() {
        List<Athlete> list = athleteRepository.findAll();
        return list.stream().map(x -> new AthleteDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true) 
    public AthleteDTO findById(Long id) {
        Optional<Athlete> obj = athleteRepository.findById(id);
        Athlete entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
        return new AthleteDTO(entity);
    }
}
