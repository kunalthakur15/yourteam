package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bowling_stats")
public class BowlingStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bowling_stats_id")
    private Integer bowlingStatsId;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne 
    @JoinColumn(name = "innings_scorecard_id")
    private InningsScorecard inningsScorecard;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "innings")
    private Integer innings;

    @Column(name = "overs")
    private Float overs;

    @Column(name = "maidens")
    private Integer maidens;

    @Column(name = "runs_conceded")
    private Integer runsConceded;

    @Column(name = "wickets")
    private Integer wickets;

    @Column(name = "econ")
    private Float econ;

    @Column(name = "wides")
    private Integer wides;

    @Column(name = "no_balls")
    private Integer noBalls;
} 