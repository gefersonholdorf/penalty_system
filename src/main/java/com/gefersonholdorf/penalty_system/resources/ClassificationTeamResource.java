package com.gefersonholdorf.penalty_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.ClassificationTeamDTO;
import com.gefersonholdorf.penalty_system.services.ClassificationTeamService;

@RestController
@RequestMapping(value = "/classification/teams")
public class ClassificationTeamResource {
    
    @Autowired
    private ClassificationTeamService classificationTeamService;

    @GetMapping
    public ResponseEntity<List<ClassificationTeamDTO>> findAll() {
        return ResponseEntity.ok().body(classificationTeamService.findAll());
    }
}
