package com.gefersonholdorf.penalty_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.MatchDTO;
import com.gefersonholdorf.penalty_system.services.MatchService;

@RestController
@RequestMapping(value = "/matches")
public class MatchResource {
    
    @Autowired
    private MatchService matchService;

    @GetMapping
    public ResponseEntity<List<MatchDTO>> findAll() {
        return ResponseEntity.ok().body(matchService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MatchDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(matchService.findById(id));
    }

    @GetMapping(value = "/group/{id}")
    public ResponseEntity<List<MatchDTO>> findByGroup(@PathVariable Long id) {
        return ResponseEntity.ok().body(matchService.findByGroup(id));
    }
}
