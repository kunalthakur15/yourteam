package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.FantasyTeam;
import com.yourteam.cricketfantasy.repository.FantasyTeamRepository;
import com.yourteam.cricketfantasy.service.FantasyTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FantasyTeamServiceImpl implements FantasyTeamService {

    @Autowired
    private FantasyTeamRepository fantasyTeamRepository;

    @Override
    public FantasyTeam createFantasyTeam(FantasyTeam fantasyTeam) {
        return fantasyTeamRepository.save(fantasyTeam);
    }

    @Override
    public FantasyTeam getFantasyTeamById(Integer id) {
        return fantasyTeamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fantasy team not found with id: " + id));
    }

    @Override
    public List<FantasyTeam> getAllFantasyTeams() {
        return fantasyTeamRepository.findAll();
    }

    @Override
    public FantasyTeam updateFantasyTeam(Integer id, FantasyTeam fantasyTeam) {
        FantasyTeam existingFantasyTeam = getFantasyTeamById(id);
        existingFantasyTeam.setFantasyTeamName(fantasyTeam.getFantasyTeamName());
        existingFantasyTeam.setUser(fantasyTeam.getUser());
        existingFantasyTeam.setMatch(fantasyTeam.getMatch());
        existingFantasyTeam.setPlayers(fantasyTeam.getPlayers());
        return fantasyTeamRepository.save(existingFantasyTeam);
    }

    @Override
    public void deleteFantasyTeam(Integer id) {
        fantasyTeamRepository.deleteById(id);
    }

    @Override
    public List<FantasyTeam> getFantasyTeamsByUser(Long userId) {
        return fantasyTeamRepository.findByUserId(userId);
    }
} 