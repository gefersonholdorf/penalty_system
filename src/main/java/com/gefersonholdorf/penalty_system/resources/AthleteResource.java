package com.gefersonholdorf.penalty_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.AthleteDTO;
import com.gefersonholdorf.penalty_system.services.AthleteService;

@RestController
@RequestMapping("/athletes")
public class AthleteResource {
    
    @Autowired
    private AthleteService athleteService;

    @GetMapping
    public ResponseEntity<List<AthleteDTO>> findAll() {
        return ResponseEntity.ok().body(athleteService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AthleteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(athleteService.findById(id));
    }

}
