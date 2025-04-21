package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.LeagueUser;
import com.yourteam.cricketfantasy.repository.LeagueUserRepository;
import com.yourteam.cricketfantasy.service.LeagueUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeagueUserServiceImpl implements LeagueUserService {

    @Autowired
    private LeagueUserRepository leagueUserRepository;

    @Override
    public LeagueUser createLeagueUser(LeagueUser leagueUser) {
        return leagueUserRepository.save(leagueUser);
    }

    @Override
    public LeagueUser getLeagueUserById(Long id) {
        return leagueUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("League user not found with id: " + id));
    }

    @Override
    public List<LeagueUser> getAllLeagueUsers() {
        return leagueUserRepository.findAll();
    }

    @Override
    public LeagueUser updateLeagueUser(Long id, LeagueUser leagueUser) {
        LeagueUser existingLeagueUser = getLeagueUserById(id);
        existingLeagueUser.setUser(leagueUser.getUser());
        existingLeagueUser.setLeagueId(leagueUser.getLeagueId());
        existingLeagueUser.setFantasyTeams(leagueUser.getFantasyTeams());
        existingLeagueUser.setRole(leagueUser.getRole());
        return leagueUserRepository.save(existingLeagueUser);
    }

    @Override
    public void deleteLeagueUser(Long id) {
        leagueUserRepository.deleteById(id);
    }
} 