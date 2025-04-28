package com.yourteam.cricketfantasy.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fantasy_leagues")
public class FantasyLeague {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "league_name")
    private String leagueName;

    @Column(name = "league_description")
    private String leagueDescription;
    
    @ManyToMany
    @JoinTable(
        name = "fantasy_league_teams",
        joinColumns = @JoinColumn(name = "league_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<FantasyTeam> fantasyTeams;
}
