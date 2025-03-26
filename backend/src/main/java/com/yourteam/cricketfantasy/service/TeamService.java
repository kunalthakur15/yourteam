package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.Team;
import java.util.List;

public interface TeamService {
    Team createTeam(Team team);
    Team getTeamById(Integer teamId);
    List<Team> getAllTeams();
    Team updateTeam(Integer teamId, Team team);
    void deleteTeam(Integer teamId);
} 