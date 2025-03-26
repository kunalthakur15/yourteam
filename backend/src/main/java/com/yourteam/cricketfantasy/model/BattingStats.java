package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "batting_stats")
public class BattingStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batting_stats_id")
    private Integer battingStatsId;

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

    @Column(name = "batting_position")
    private Integer battingPosition;

    @Column(name = "runs_scored")
    private Integer runsScored;

    @Column(name = "balls_faced")
    private Integer ballsFaced;

    @Column(name = "fours")
    private Integer fours;

    @Column(name = "sixes")
    private Integer sixes;

    @Column(name = "strike_rate")
    private Float strikeRate;

    @OneToOne
    @JoinColumn(name = "bowler_id")
    private Player bowler;

    @Enumerated(EnumType.STRING)
    @Column(name = "dismissal_type")
    private DismissalType dismissalType;

    @OneToOne
    @JoinColumn(name = "fielder1_id")
    private Player fielder1;

    @OneToOne
    @JoinColumn(name = "fielder2_id")
    private Player fielder2;
} 