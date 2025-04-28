package com.yourteam.cricketfantasy.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "innings_scorecards")
public class InningsScorecard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "innings_scorecard_id")
    private Integer inningsScorecardId;

    @Column(name = "inning_number")
    private Integer inningNumber;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @OneToMany (mappedBy = "inningsScorecard")
    private List <BattingStats> battingStats;

    @OneToMany (mappedBy = "inningsScorecard")
    private List <BowlingStats> bowlingStats;

    @Column(name = "runs")
    private Integer runs;

    @Column(name = "wickets")
    private Integer wickets;

    @Column(name = "overs")
    private Float overs;

    @Column(name = "extras")
    private Integer extras;

    public Object getInnings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInnings'");
    }

    public void setInnings(Object innings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInnings'");
    }

    public Object getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }

    public void setTeam(Object team) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTeam'");
    }
} 