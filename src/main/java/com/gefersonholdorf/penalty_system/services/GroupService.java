package com.gefersonholdorf.penalty_system.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.GroupDTO;
import com.gefersonholdorf.penalty_system.entities.ClassificationTeam;
import com.gefersonholdorf.penalty_system.entities.Group;
import com.gefersonholdorf.penalty_system.repositories.ClassificationTeamRepository;
import com.gefersonholdorf.penalty_system.repositories.GroupRepository;
import com.gefersonholdorf.penalty_system.services.exceptions.ResourceNotFoundException;

@Service
public class GroupService {
    
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ClassificationTeamRepository classificationTeamRepository;

    @Transactional
    public List<GroupDTO> findAll() {
        List<Group> list = groupRepository.findAll();
        
        List<ClassificationTeam> listClassification = classificationTeamRepository.updateTableClassification();

        for(Integer i = 0; i < list.size(); i++) { 
            List<ClassificationTeam> newList = new ArrayList<>();
            for(ClassificationTeam t : listClassification) {
                for (Integer j = 0; j < list.get(i).getTeams().size(); j++) {
                    if (t.equals(list.get(i).getTeams().get(j)))  {
                    newList.add(t);
                    }
                }
            }

            list.get(i).setTeams(newList);
            updatedPositions(newList);
        }

        return list.stream().map(x -> new GroupDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public GroupDTO findById(Long id) {
        Optional<Group> obj = groupRepository.findById(id);
        Group entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
        List<ClassificationTeam> listClassification = classificationTeamRepository.updateTableClassification();
        List<ClassificationTeam> newList = new ArrayList<>();

        for(ClassificationTeam t : listClassification) {
            if (t.getGroup().getId() == id) {
                newList.add(t);
            }
        }
        entity.setTeams(newList);
        updatedPositions(newList);
        return new GroupDTO(entity);
    }

    static void updatedPositions(List<ClassificationTeam> classification) {
        Integer i = 1;

        for (ClassificationTeam c : classification) {
            c.setPosition(i + "º");
            i++;
        }
    }
}
