package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.BowlingStats;
import java.util.List;

public interface BowlingStatsService {
    BowlingStats createBowlingStats(BowlingStats bowlingStats);
    BowlingStats getBowlingStatsById(Integer bowlingStatsId);
    List<BowlingStats> getAllBowlingStats();
    BowlingStats updateBowlingStats(Integer bowlingStatsId, BowlingStats bowlingStats);
    void deleteBowlingStats(Integer bowlingStatsId);
} 