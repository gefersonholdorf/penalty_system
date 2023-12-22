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
import com.gefersonholdorf.penalty_system.entities.ClassificationTeam;
import com.gefersonholdorf.penalty_system.entities.Match;
import com.gefersonholdorf.penalty_system.entities.Result;
import com.gefersonholdorf.penalty_system.entities.Team;
import com.gefersonholdorf.penalty_system.enums.Position;
import com.gefersonholdorf.penalty_system.repositories.ClassificationTeamRepository;
import com.gefersonholdorf.penalty_system.repositories.MatchRepository;
import com.gefersonholdorf.penalty_system.repositories.ResultRepository;

@Service
public class ResultService {
    
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ClassificationTeamRepository classificationTeamRepository;

    @Transactional(readOnly = true)
    public List<ResultDTO> findAll() {
        List<Result> list = resultRepository.findAll();
        return list.stream().map(x -> new ResultDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public InsertResultDTO insert(InsertResultDTO dto) {
        Match match = matchRepository.getReferenceById(dto.getMatch());
        ClassificationTeam homeTeam = classificationTeamRepository.getReferenceById(match.getHomeTeam().getId());
        ClassificationTeam visitingTeam = classificationTeamRepository.getReferenceById(match.getVisitingTeam().getId());

        //Entity created
        Result entity = new Result();
        entity.setId(dto.getId());
        Integer goalsHomeTeam = simulatedMatch(visitingTeam.getTeam(), visitingTeam.getTeam());
        Integer goalsVisitingTeam = simulatedMatch(visitingTeam.getTeam(), homeTeam.getTeam());
        entity.setHomeTeamGoals(goalsHomeTeam);
        entity.setVisitingTeamGoals(goalsVisitingTeam);
        entity.setMatch(match);

        //MathSimulation
        homeTeam.setGoalsFor(homeTeam.getGoalsFor() + goalsHomeTeam);
        homeTeam.setOwnGoals(homeTeam.getOwnGoals() + goalsVisitingTeam);
        homeTeam.setBalance(homeTeam.getGoalsFor() - homeTeam.getOwnGoals());
        homeTeam.setGames(homeTeam.getGames() + 1);
        visitingTeam.setGoalsFor(visitingTeam.getGoalsFor() + goalsVisitingTeam);
        visitingTeam.setOwnGoals(visitingTeam.getOwnGoals() + goalsHomeTeam);
        visitingTeam.setBalance(visitingTeam.getGoalsFor() - visitingTeam.getOwnGoals());
        visitingTeam.setGames(visitingTeam.getGames() + 1);

        if (goalsHomeTeam > goalsVisitingTeam) {
            homeTeam.setVictories(homeTeam.getVictories() + 1);
            homeTeam.setPoints(homeTeam.getPoints() + 3);
            visitingTeam.setDefeats(visitingTeam.getDefeats() + 1);
        }
        else if (goalsHomeTeam < goalsVisitingTeam) {
            visitingTeam.setVictories(visitingTeam.getVictories() + 1);
            visitingTeam.setPoints(visitingTeam.getPoints() + 3);
            homeTeam.setDefeats(homeTeam.getDefeats() + 1);
        }
        else {
            homeTeam.setDraws(homeTeam.getDraws() + 1);
            homeTeam.setPoints(homeTeam.getPoints() + 1);
            visitingTeam.setDraws(visitingTeam.getDraws() + 1);
            visitingTeam.setPoints(visitingTeam.getPoints() + 1);
        }

        classificationTeamRepository.save(homeTeam);
        classificationTeamRepository.save(visitingTeam);
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
