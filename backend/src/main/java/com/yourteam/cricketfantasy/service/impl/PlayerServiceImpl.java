package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.PlayerRole;
import com.yourteam.cricketfantasy.repository.PlayerRepository;
import com.yourteam.cricketfantasy.service.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    @Transactional
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Integer playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + playerId));
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
    @Transactional
    public Player updatePlayer(Integer playerId, Player playerDetails) {
        Player player = getPlayerById(playerId);
        player.setFirstName(playerDetails.getFirstName());
        player.setMiddleName(playerDetails.getMiddleName());
        player.setLastName(playerDetails.getLastName());
        player.setDateOfBirth(playerDetails.getDateOfBirth());
        player.setNationality(playerDetails.getNationality());
        player.setRole(playerDetails.getRole());
        player.setBattingStyle(playerDetails.getBattingStyle());
        player.setBowlingStyle(playerDetails.getBowlingStyle());
        player.setTeams(playerDetails.getTeams());
        return playerRepository.save(player);
    }

    @Override
    @Transactional
    public void deletePlayer(Integer playerId) {
        Player player = getPlayerById(playerId);
        playerRepository.delete(player);
    }
} 