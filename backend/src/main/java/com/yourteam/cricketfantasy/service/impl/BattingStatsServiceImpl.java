package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.BattingStats;
import com.yourteam.cricketfantasy.repository.BattingStatsRepository;
import com.yourteam.cricketfantasy.service.BattingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BattingStatsServiceImpl implements BattingStatsService {

    @Autowired
    private BattingStatsRepository battingStatsRepository;

    @Override
    public BattingStats createBattingStats(BattingStats battingStats) {
        return battingStatsRepository.save(battingStats);
    }

    @Override
    public BattingStats getBattingStatsById(Integer battingStatsId) {
        return battingStatsRepository.findById(battingStatsId)
                .orElseThrow(() -> new RuntimeException("Batting stats not found with id: " + battingStatsId));
    }

    @Override
    public List<BattingStats> getAllBattingStats() {
        return battingStatsRepository.findAll();
    }

    @Override
    public BattingStats updateBattingStats(Integer battingStatsId, BattingStats battingStats) {
        BattingStats existingBattingStats = getBattingStatsById(battingStatsId);
        existingBattingStats.setInningsScorecard(battingStats.getInningsScorecard());
        existingBattingStats.setPlayer(battingStats.getPlayer());
        existingBattingStats.setTeam(battingStats.getTeam());
        existingBattingStats.setBattingPosition(battingStats.getBattingPosition());
        existingBattingStats.setRunsScored(battingStats.getRunsScored());
        existingBattingStats.setBallsFaced(battingStats.getBallsFaced());
        existingBattingStats.setFours(battingStats.getFours());
        existingBattingStats.setSixes(battingStats.getSixes());
        existingBattingStats.setStrikeRate(battingStats.getStrikeRate());
        existingBattingStats.setBowler(battingStats.getBowler());
        existingBattingStats.setDismissalType(battingStats.getDismissalType());
        existingBattingStats.setFielder1(battingStats.getFielder1());
        existingBattingStats.setFielder2(battingStats.getFielder2());
        return battingStatsRepository.save(existingBattingStats);
    }

    @Override
    public void deleteBattingStats(Integer battingStatsId) {
        battingStatsRepository.deleteById(battingStatsId);
    }

} 