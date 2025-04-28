package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @OneToMany (mappedBy = "match")
    private List <InningsScorecard> inningsScorecards;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @Column(name = "match_year")
    private Integer matchYear;

    @Column(name = "venue")
    private String venue;

    @Column(name = "venue_city")
    private String venueCity;

    @OneToOne
    @JoinColumn(name = "team1_id")
    private Team team1;

    @OneToOne
    @JoinColumn(name = "team1_captain_id")
    private Player team1Captain;

    @OneToOne
    @JoinColumn(name = "team2_id")
    private Team team2;

    @OneToOne
    @JoinColumn(name = "team2_captain_id")
    private Player team2Captain;

    @OneToOne
    @JoinColumn(name = "toss_winner_id")
    private Team tossWinner;

    @Column(name = "toss_decision")
    private String tossDecision;

    @Column(name = "was_super_over")
    private Boolean wasSuperOver;

    @OneToOne
    @JoinColumn(name = "winning_team_id")
    private Team winningTeam;

    @Column(name = "won_by")
    private String wonBy;

    @Column(name = "win_margin")
    private Integer winMargin;

    @OneToOne
    @JoinColumn(name = "mom")
    private Player manOfTheMatch;

    @OneToOne
    @JoinColumn(name = "umpire_1")
    private Umpire umpire1;

    @OneToOne
    @JoinColumn(name = "umpire_2")
    private Umpire umpire2;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_type")
    private MatchType matchType;
} 