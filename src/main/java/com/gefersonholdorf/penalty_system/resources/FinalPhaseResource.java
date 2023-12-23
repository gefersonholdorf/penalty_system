package com.gefersonholdorf.penalty_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.FinalPhaseDTO;
import com.gefersonholdorf.penalty_system.dtos.TeamDTO;
import com.gefersonholdorf.penalty_system.services.FinalPhaseService;

@RestController
@RequestMapping(value = "/finalphases")
public class FinalPhaseResource {
    
    @Autowired
    private FinalPhaseService finalPhaseService;

    @GetMapping
    public ResponseEntity<List<FinalPhaseDTO>> findById() {
        return ResponseEntity.ok().body(finalPhaseService.findAll());
    }

    @PostMapping(value = "/{id}/teams")
    public ResponseEntity<List<TeamDTO>> create(@PathVariable Long id) {
        return ResponseEntity.ok().body(finalPhaseService.create(id));
    }

}
