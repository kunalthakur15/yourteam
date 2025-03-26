package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "team_name", length = 255)
    private String teamName;

    @Column(name = "team_logo", length = 255)
    private String teamLogo;
} 