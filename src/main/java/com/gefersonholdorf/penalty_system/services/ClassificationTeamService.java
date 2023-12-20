package com.gefersonholdorf.penalty_system.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.ClassificationTeamDTO;
import com.gefersonholdorf.penalty_system.entities.ClassificationTeam;
import com.gefersonholdorf.penalty_system.repositories.ClassificationTeamRepository;

@Service
public class ClassificationTeamService {
    
    @Autowired
    private ClassificationTeamRepository classificationTeamRepository;

    @Transactional(readOnly = true)
    public List<ClassificationTeamDTO> findAll() {
        List<ClassificationTeam> list = classificationTeamRepository.findAll();
        return list.stream().map(x -> new ClassificationTeamDTO(x)).collect(Collectors.toList());
    }
}
