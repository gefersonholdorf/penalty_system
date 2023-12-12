package com.gefersonholdorf.penalty_system.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.GroupDTO;
import com.gefersonholdorf.penalty_system.entities.Group;
import com.gefersonholdorf.penalty_system.repositories.GroupRepository;
import com.gefersonholdorf.penalty_system.services.exceptions.ResourceNotFoundException;

@Service
public class GroupService {
    
    @Autowired
    private GroupRepository groupRepository;

    @Transactional(readOnly = true)
    public List<GroupDTO> findAll() {
        List<Group> list = groupRepository.findAll();
        return list.stream().map(x -> new GroupDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GroupDTO findById(Long id) {
        Optional<Group> obj = groupRepository.findById(id);
        Group entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
        return new GroupDTO(entity);
    }
}
