package com.yourteam.cricketfantasy.model;

public enum PlayerRole {
    BATSMAN("Batsman"),
    BOWLER("Bowler"),
    ALL_ROUNDER("All-Rounder"),
    WICKET_KEEPER("Wicket-Keeper");

    private final String displayName;

    PlayerRole(String displayName) {
        this.displayName = displayName;
    }
} 