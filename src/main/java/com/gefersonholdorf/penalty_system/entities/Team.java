package com.gefersonholdorf.penalty_system.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_team")
public class Team{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gymnasium;
    private Double pot;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    List<Athlete> athletes = new ArrayList<>();

    @OneToMany(mappedBy = "homeTeam")
    List<Match> listHomeTeams = new ArrayList<>();

    @OneToMany(mappedBy = "visitingTeam")
    List<Match> listVisitingTeams = new ArrayList<>();  
    
    @OneToOne(mappedBy = "team")
    private ClassificationTeam classificationTeam;

    @ManyToOne
    @JoinColumn(name = "final_phase_id")
    private FinalPhase finalPhase;
}