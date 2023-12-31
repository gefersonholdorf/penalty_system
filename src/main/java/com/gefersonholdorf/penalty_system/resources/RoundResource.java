package com.gefersonholdorf.penalty_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.InsertRoundDTO;
import com.gefersonholdorf.penalty_system.dtos.RoundDTO;
import com.gefersonholdorf.penalty_system.services.RoundService;

@RestController
@RequestMapping(value = "/rounds")
public class RoundResource {

    @Autowired
    private RoundService roundService;

    @GetMapping
    public ResponseEntity <List<RoundDTO>> findAll() {
        return ResponseEntity.ok().body(roundService.findAll());
    }

    @GetMapping(value = "/create")
    public ResponseEntity<List<RoundDTO>> createRounds() {
        return ResponseEntity.ok().body(roundService.createRounds());
    }

    @PostMapping
    public ResponseEntity<InsertRoundDTO> insert (@RequestBody InsertRoundDTO dto) {
        return ResponseEntity.ok().body(roundService.insert(dto));
    }
    
}