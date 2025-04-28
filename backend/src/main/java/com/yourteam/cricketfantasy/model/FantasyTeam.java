package com.yourteam.cricketfantasy.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fantasy_team")
public class FantasyTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fantasy_team_name")
    private String fantasyTeamName;

    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "fantasy_team_players",
        joinColumns = @JoinColumn(name = "fantasy_team_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;
    
    @ManyToMany
    @JoinTable(
        name = "fantasy_team_leagues",
        joinColumns = @JoinColumn(name = "fantasy_team_id"),
        inverseJoinColumns = @JoinColumn(name = "league_id")
    )
    private List<FantasyLeague> fantasyLeagues;
}