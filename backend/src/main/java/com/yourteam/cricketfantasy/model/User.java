package com.yourteam.cricketfantasy.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 100)
    private Integer phone;

    @Column(name = "password", length = 100)
    private String password;

    @OneToMany (mappedBy = "user")
    private List <FantasyTeam> fantasyTeams;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private LeagueRole role;
} 