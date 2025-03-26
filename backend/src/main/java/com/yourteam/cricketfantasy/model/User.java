package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @Column(name = "fantasy_league_id")
    private Integer fantasyLeagueId;

    @Column(name = "fantasy_team_id")
    private Integer fantasyTeamId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 100)
    private Integer phone;

    @Column(name = "password", length = 100)
    private String password;
} 