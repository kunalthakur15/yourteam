package com.yourteam.cricketfantasy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;   
import lombok.Data;

@Data
@Entity
@Table(name = "fall_of_wickets")
public class FallOfWickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "innings_scorecard_id")
    private InningsScorecard inningsScorecard;  

    @Column(name = "wicket_number")
    private Integer wicketNumber;

    @Column(name = "score_at_wicket")
    private Integer scoreAtWicket;

    @Column(name = "overs_at_wicket")
    private Float oversAtWicket;

    @Column(name = "partnership_runs")
    private Integer partnershipRuns;

    @ManyToOne
    @JoinColumn(name = "batsman_out_id")
    private Player batsmanOut;

    @ManyToOne
    @JoinColumn(name = "non_striker_id")
    private Player nonStriker;
}   
