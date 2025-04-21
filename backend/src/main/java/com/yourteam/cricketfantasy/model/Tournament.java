package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Year;
import java.util.List;

@Data
@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Integer tournamentId;

    @Column(name = "tournament_name", length = 255)
    private String tournamentName;

    @Column(name = "year")
    private Year year;

    @Column(name = "location", length = 255)
    private String location;

    @OneToMany (mappedBy = "tournament")
    private List <Match> matches;

    @ManyToMany
    @JoinTable(
        name = "team_tournaments",
        joinColumns = @JoinColumn(name = "tournament_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List <Team> teams;
} 