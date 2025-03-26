package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.PlayerRole;
import java.util.List;

public interface PlayerService {
    Player createPlayer(Player player);
    Player getPlayerById(Integer playerId);
    List<Player> getAllPlayers();
    List<Player> getPlayersByTeam(Integer teamId);
    List<Player> getPlayersByRole(PlayerRole role);
    List<Player> getPlayersByTeamAndRole(Integer teamId, PlayerRole role);
    Player updatePlayer(Integer playerId, Player player);
    void deletePlayer(Integer playerId);
} 