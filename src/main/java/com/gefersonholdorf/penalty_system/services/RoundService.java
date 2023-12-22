package com.gefersonholdorf.penalty_system.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.penalty_system.dtos.RoundDTO;
import com.gefersonholdorf.penalty_system.entities.ClassificationTeam;
import com.gefersonholdorf.penalty_system.entities.Group;
import com.gefersonholdorf.penalty_system.entities.Match;
import com.gefersonholdorf.penalty_system.entities.Round;
import com.gefersonholdorf.penalty_system.repositories.GroupRepository;
import com.gefersonholdorf.penalty_system.repositories.MatchRepository;
import com.gefersonholdorf.penalty_system.repositories.RoundRepository;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private MatchRepository matchRepository;



    @Transactional
    public List<RoundDTO> createRounds() {
        List<Group> listGroups = groupRepository.findAll();
        List<Round> roundsAll = new ArrayList<>();

        //Check group by group
        for(Group g : listGroups) {

            //Teams by group
            List<ClassificationTeam> listTeams = g.getTeams();

            List<Round> rounds = new ArrayList<>();

            //Created Round
            for (Integer i = 0; i < listTeams.size() - 1; i++) {

                Round round = new Round();
                round.setNumberRound((i + 1) + " Round");

                //Store matches
                List<Match> matches = new ArrayList<>();

                for (int j = 0; j < listTeams.size() / 2; j++) {
                    //Create and Save Match
                    Match match = new Match();
                    match.setData(Instant.now());
                    match.setHomeTeam(listTeams.get(j).getTeam());
                    match.setVisitingTeam(listTeams.get(listTeams.size() - 1 - j).getTeam());
                    match.setGroup(g);
                    match.setRound(round);
                    matchRepository.save(match);
            
                    matches.add(match);
                }
             
                round.setMatches(matches);
                round.setGroup(g);
                roundRepository.save(round);

                // Rotaciona os times para a próxima rodada
                listTeams.add(1, listTeams.remove(listTeams.size() - 1));

                rounds.add(round);
            }

            //Create All rounds
            roundsAll.addAll(rounds);
        }

        return roundsAll.stream().map(x -> new RoundDTO(x)).collect(Collectors.toList());
    }
    
}
