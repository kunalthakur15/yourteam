package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.LeagueUser;
import java.util.List;

public interface LeagueUserService {
    LeagueUser createLeagueUser(LeagueUser leagueUser);
    LeagueUser getLeagueUserById(Long id);
    List<LeagueUser> getAllLeagueUsers();
    LeagueUser updateLeagueUser(Long id, LeagueUser leagueUser);
    void deleteLeagueUser(Long id);
} 