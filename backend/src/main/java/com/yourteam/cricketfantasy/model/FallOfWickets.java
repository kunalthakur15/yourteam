package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fall_of_wickets")
public class FallOfWickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fall_of_wicket_id")
    private Integer fallOfWicketId;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "innings")
    private Integer innings;

    @Column(name = "wicket_number")
    private Integer wicketNumber;

    @Column(name = "runs_at_wicket")
    private Integer runsAtWicket;

    @Column(name = "overs_at_wicket")
    private Float oversAtWicket;

    @ManyToOne
    @JoinColumn(name = "batsman_out_id")
    private Player batsmanOut;

    @ManyToOne
    @JoinColumn(name = "bowler_id")
    private Player bowler;

    @ManyToOne
    @JoinColumn(name = "partner_1_id")
    private Player partner1;

    @ManyToOne
    @JoinColumn(name = "partner_2_id")
    private Player partner2;
} 