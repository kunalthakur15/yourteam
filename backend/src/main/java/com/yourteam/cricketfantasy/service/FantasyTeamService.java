package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.FantasyTeam;
import java.util.List;

public interface FantasyTeamService {
    FantasyTeam createFantasyTeam(FantasyTeam fantasyTeam);
    FantasyTeam getFantasyTeamById(Integer id);
    List<FantasyTeam> getAllFantasyTeams();
    List<FantasyTeam> getFantasyTeamsByUser(Long userId);
    FantasyTeam updateFantasyTeam(Integer id, FantasyTeam fantasyTeam);
    void deleteFantasyTeam(Integer id);
} 