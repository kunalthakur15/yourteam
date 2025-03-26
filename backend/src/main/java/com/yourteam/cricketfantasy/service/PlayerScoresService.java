package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.BattingStats;
import com.yourteam.cricketfantasy.model.Team;
import java.util.List;

public interface PlayerScoresService {
    BattingStats createPlayerScores(BattingStats playerScores);
    BattingStats getPlayerScoresById(Integer playerScoreId);
    List<BattingStats> getAllPlayerScores();
    List<BattingStats> getPlayerScoresByMatch(Integer matchId);
    List<BattingStats> getPlayerScoresByPlayer(Player player);
    List<BattingStats> getPlayerScoresByTeam(Team team);
    List<BattingStats> getPlayerScoresByMatchAndTeam(Integer matchId, Integer teamId);
    List<BattingStats> getPlayerScoresByMatchAndInnings(Integer matchId, Integer innings);
    List<BattingStats> getPlayerScoresByBowler(Player bowler);
    BattingStats updatePlayerScores(Integer playerScoreId, BattingStats playerScores);
    void deletePlayerScores(Integer playerScoreId);
} 