package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.BowlingStats;
import java.util.List;

public interface BowlingStatsService {
    BowlingStats createBowlingStats(BowlingStats bowlingStats);
    BowlingStats getBowlingStatsById(Integer bowlingStatsId);
    List<BowlingStats> getAllBowlingStats();
    List<BowlingStats> getBowlingStatsByMatch(Integer matchId);
    List<BowlingStats> getBowlingStatsByPlayer(Integer playerId);
    List<BowlingStats> getBowlingStatsByTeam(Integer teamId);
    List<BowlingStats> getBowlingStatsByMatchAndTeam(Integer matchId, Integer teamId);
    List<BowlingStats> getBowlingStatsByMatchAndInnings(Integer matchId, Integer innings);
    BowlingStats updateBowlingStats(Integer bowlingStatsId, BowlingStats bowlingStats);
    void deleteBowlingStats(Integer bowlingStatsId);
} 