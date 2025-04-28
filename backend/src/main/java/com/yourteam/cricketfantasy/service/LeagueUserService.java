package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.User;
import java.util.List;

public interface LeagueUserService {
    User createLeagueUser(User user);
    User getLeagueUserById(Long id);
    List<User> getAllLeagueUsers();
    User updateLeagueUser(Long id, User user);
    void deleteLeagueUser(Long id);
} 