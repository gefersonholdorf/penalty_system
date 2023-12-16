package com.gefersonholdorf.penalty_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.InsertResultDTO;
import com.gefersonholdorf.penalty_system.dtos.ResultDTO;
import com.gefersonholdorf.penalty_system.services.ResultService;

@RestController
@RequestMapping(value = "/results")
public class ResultResource {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public ResponseEntity<List<ResultDTO>> findAll(){
        return ResponseEntity.ok().body(resultService.findAll());
    }

    @PostMapping
    public ResponseEntity<InsertResultDTO> insert(@RequestBody InsertResultDTO dto) {
        InsertResultDTO saveResult = resultService.insert(dto);
        return new ResponseEntity<>(saveResult, HttpStatus.CREATED);
    }
    
}
