package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.BattingStats;
import java.util.List;

public interface BattingStatsService {
    BattingStats createBattingStats(BattingStats battingStats);
    BattingStats getBattingStatsById(Integer battingStatsId);
    List<BattingStats> getAllBattingStats();
    List<BattingStats> getBattingStatsByMatch(Integer matchId);
    List<BattingStats> getBattingStatsByPlayer(Integer playerId);
    List<BattingStats> getBattingStatsByTeam(Integer teamId);
    List<BattingStats> getBattingStatsByMatchAndTeam(Integer matchId, Integer teamId);
    List<BattingStats> getBattingStatsByMatchAndInnings(Integer matchId, Integer innings);
    BattingStats updateBattingStats(Integer battingStatsId, BattingStats battingStats);
    void deleteBattingStats(Integer battingStatsId);
} 