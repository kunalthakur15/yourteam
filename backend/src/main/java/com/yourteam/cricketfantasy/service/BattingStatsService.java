package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.BattingStats;
import java.util.List;

public interface BattingStatsService {
    BattingStats createBattingStats(BattingStats battingStats);
    BattingStats getBattingStatsById(Integer battingStatsId);
    List<BattingStats> getAllBattingStats();
    BattingStats updateBattingStats(Integer battingStatsId, BattingStats battingStats);
    void deleteBattingStats(Integer battingStatsId);
} 