package com.gefersonholdorf.penalty_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.ChampionshipDTO;
import com.gefersonholdorf.penalty_system.entities.Championship;
import com.gefersonholdorf.penalty_system.repositories.ChampionshipRepository;

@Service
public class ChampionshipService {
    
    @Autowired
    private ChampionshipRepository championshipRepository;

    @Transactional(readOnly = true)
    public ChampionshipDTO findById (Long id) {
        Championship entity = championshipRepository.getReferenceById(id);
        return new ChampionshipDTO(entity);
    }
}
