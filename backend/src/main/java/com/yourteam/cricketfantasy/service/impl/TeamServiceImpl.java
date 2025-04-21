package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.repository.TeamRepository;
import com.yourteam.cricketfantasy.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Integer teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(Integer teamId, Team team) {
        Team existingTeam = getTeamById(teamId);
        existingTeam.setTeamName(team.getTeamName());
        existingTeam.setTeamLogo(team.getTeamLogo());
        existingTeam.setPlayers(team.getPlayers());
        existingTeam.setTournaments(team.getTournaments());
        return teamRepository.save(existingTeam);
    }

    @Override
    public void deleteTeam(Integer teamId) {
        teamRepository.deleteById(teamId);
    }

    @Override
    public List<Team> getTeamsByTournament(Integer tournamentId) {
        return teamRepository.findByTournamentsTournamentId(tournamentId);
    }
} 