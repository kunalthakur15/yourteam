package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.PlayerRole;
import com.yourteam.cricketfantasy.repository.PlayerRepository;
import com.yourteam.cricketfantasy.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Integer playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getPlayersByTeam(Integer teamId) {
        return playerRepository.findByTeamTeamId(teamId);
    }

    @Override
    public List<Player> getPlayersByRole(PlayerRole role) {
        return playerRepository.findByRole(role);
    }

    @Override
    public List<Player> getPlayersByTeamAndRole(Integer teamId, PlayerRole role) {
        return playerRepository.findByTeamTeamIdAndRole(teamId, role);
    }

    @Override
    public Player updatePlayer(Integer playerId, Player player) {
        Player existingPlayer = getPlayerById(playerId);
        existingPlayer.setFirstName(player.getFirstName());
        existingPlayer.setMiddleName(player.getMiddleName());
        existingPlayer.setLastName(player.getLastName());
        existingPlayer.setDateOfBirth(player.getDateOfBirth());
        existingPlayer.setNationality(player.getNationality());
        existingPlayer.setRole(player.getRole());
        existingPlayer.setBattingStyle(player.getBattingStyle());
        existingPlayer.setBowlingStyle(player.getBowlingStyle());
        existingPlayer.setTeams(player.getTeams());
        return playerRepository.save(existingPlayer);
    }

    @Override
    public void deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
    }
} 