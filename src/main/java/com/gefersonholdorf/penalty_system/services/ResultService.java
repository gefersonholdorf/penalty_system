package com.gefersonholdorf.penalty_system.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.InsertResultDTO;
import com.gefersonholdorf.penalty_system.dtos.ResultDTO;
import com.gefersonholdorf.penalty_system.entities.Athlete;
import com.gefersonholdorf.penalty_system.entities.Match;
import com.gefersonholdorf.penalty_system.entities.Result;
import com.gefersonholdorf.penalty_system.entities.Team;
import com.gefersonholdorf.penalty_system.enums.Position;
import com.gefersonholdorf.penalty_system.repositories.MatchRepository;
import com.gefersonholdorf.penalty_system.repositories.ResultRepository;

@Service
public class ResultService {
    
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Transactional(readOnly = true)
    public List<ResultDTO> findAll() {
        List<Result> list = resultRepository.findAll();
        return list.stream().map(x -> new ResultDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InsertResultDTO insert(InsertResultDTO dto) {
        Match match = matchRepository.getReferenceById(dto.getMatch());
        Result entity = new Result();
        entity.setId(dto.getId());
        entity.setHomeTeamGoals(simulatedMatch(match.getHomeTeam(), match.getVisitingTeam()));
        entity.setVisitingTeamGoals(simulatedMatch(match.getVisitingTeam(), match.getHomeTeam()));
        entity.setMatch(match);
        resultRepository.save(entity);
        return new InsertResultDTO(entity);
    }

   static Integer simulatedMatch(Team oneTeam, Team twoTeam) {
        Integer goals = 0;
        List<Athlete> athletesOneTeam = oneTeam.getAthletes().stream().filter(x -> x.getPosition() == Position.ATTACKER).collect(Collectors.toList());

        for(Integer i = 0; i < 3; i++) {
            for(Integer j = 0; j < athletesOneTeam.size(); j++) {
                if(kick(oneTeam, twoTeam, athletesOneTeam.get(j))){
                    goals += 1;
                }
            }
        }

        return goals;
   }

   static boolean kick(Team oneTeam, Team twoTeam, Athlete athlete) {
        Random random = new Random();

        Double strengthHomeTeam = ((athlete.getHab() * oneTeam.getPot()) / twoTeam.getPot()) * athlete.getPot();
        Double strenghtVisitingTeam = ((twoTeam.getAthletes().get(0).getHab() * twoTeam.getPot()) / oneTeam.getPot()) * twoTeam.getAthletes().get(0).getPot();
        Double percentualValue = strengthHomeTeam + strenghtVisitingTeam;

        Double percentualHomeTeam = (strengthHomeTeam / percentualValue) * 100;

        Integer randomNumber = random.nextInt(100);

        return (randomNumber < percentualHomeTeam) ? true : false;
   }

}
