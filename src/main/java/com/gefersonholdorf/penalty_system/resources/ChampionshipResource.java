package com.gefersonholdorf.penalty_system.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.ChampionshipDTO;
import com.gefersonholdorf.penalty_system.services.ChampionshipService;

@RestController
@RequestMapping(value = "/champions")
public class ChampionshipResource {
    
    @Autowired
    private ChampionshipService championshipService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChampionshipDTO> findById (@PathVariable Long id) {
        return ResponseEntity.ok().body(championshipService.findById(id));
    }
}
