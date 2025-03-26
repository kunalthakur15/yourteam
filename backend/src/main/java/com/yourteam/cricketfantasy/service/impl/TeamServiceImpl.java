package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.repository.TeamRepository;
import com.yourteam.cricketfantasy.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    @Transactional
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Integer teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with id: " + teamId));
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    @Transactional
    public Team updateTeam(Integer teamId, Team teamDetails) {
        Team team = getTeamById(teamId);
        team.setTeamName(teamDetails.getTeamName());
        team.setTeamLogo(teamDetails.getTeamLogo());
        return teamRepository.save(team);
    }

    @Override
    @Transactional
    public void deleteTeam(Integer teamId) {
        Team team = getTeamById(teamId);
        teamRepository.delete(team);
    }
} 