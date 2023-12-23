package com.gefersonholdorf.penalty_system.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gefersonholdorf.penalty_system.dtos.FinalPhaseDTO;
import com.gefersonholdorf.penalty_system.dtos.TeamDTO;
import com.gefersonholdorf.penalty_system.entities.Group;
import com.gefersonholdorf.penalty_system.entities.Team;
import com.gefersonholdorf.penalty_system.entities.ClassificationTeam;
import com.gefersonholdorf.penalty_system.entities.FinalPhase;
import com.gefersonholdorf.penalty_system.repositories.ClassificationTeamRepository;
import com.gefersonholdorf.penalty_system.repositories.FinalPhaseRepository;
import com.gefersonholdorf.penalty_system.repositories.GroupRepository;
import com.gefersonholdorf.penalty_system.repositories.TeamRepository;

@Service
public class FinalPhaseService {

    @Autowired
    private FinalPhaseRepository finalPhaseRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ClassificationTeamRepository classificationTeamRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Transactional(readOnly = true)
    public List<FinalPhaseDTO> findAll() {
        List<FinalPhase> list = finalPhaseRepository.findAll();
        return list.stream().map(x -> new FinalPhaseDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<TeamDTO> create(Long id) {
        FinalPhase entity = finalPhaseRepository.getReferenceById(id);

        List<Group> listGroups = groupRepository.findAll();

        List<ClassificationTeam> listTeams = classificationTeamRepository.updateTableClassification();

        List<Team> qualifiedTeams = new ArrayList<>();

        for (Integer i = 0; i < listGroups.size(); i++) {
            for (Integer j = 0; j < listTeams.size(); j++) {
                if (listTeams.get(j).getGroup().getId() == listGroups.get(i).getId()) {
                    if (listTeams.get(j).getPosition() == 1 || listTeams.get(j).getPosition() == 2) {
                        qualifiedTeams.add(listTeams.get(j).getTeam());
                        listTeams.get(j).getTeam().setFinalPhase(entity);
                        teamRepository.save(listTeams.get(j).getTeam());
                    } 
                }
            }
        }
        
        entity.setTeams(qualifiedTeams);
        finalPhaseRepository.save(entity);

        return qualifiedTeams.stream().map(x -> new TeamDTO(x)).collect(Collectors.toList());
    }
    
}
