package com.yourteam.cricketfantasy.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "league_users")
public class LeagueUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private Long leagueId;

    @OneToMany(mappedBy = "leagueUser")
    private List<FantasyTeam> fantasyTeams;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private LeagueRole role;
}
