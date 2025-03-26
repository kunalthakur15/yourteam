package com.yourteam.cricketfantasy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "umpires")
public class Umpire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "umpire_id")
    private Integer umpireId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;
} 