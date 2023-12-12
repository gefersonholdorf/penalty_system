package com.gefersonholdorf.penalty_system.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.penalty_system.dtos.GroupDTO;
import com.gefersonholdorf.penalty_system.services.GroupService;

@RestController
@RequestMapping(value = "/groups")
public class GroupResource {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupDTO>> findAll() {
        return ResponseEntity.ok().body(groupService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GroupDTO> findById(@PathVariable Long id) {
        GroupDTO dto = groupService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    
}
