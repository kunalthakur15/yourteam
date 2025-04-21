package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.BowlingStats;
import com.yourteam.cricketfantasy.repository.BowlingStatsRepository;
import com.yourteam.cricketfantasy.service.BowlingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BowlingStatsServiceImpl implements BowlingStatsService {

    @Autowired
    private BowlingStatsRepository bowlingStatsRepository;

    @Override
    public BowlingStats createBowlingStats(BowlingStats bowlingStats) {
        return bowlingStatsRepository.save(bowlingStats);
    }

    @Override
    public BowlingStats getBowlingStatsById(Integer bowlingStatsId) {
        return bowlingStatsRepository.findById(bowlingStatsId)
                .orElseThrow(() -> new RuntimeException("Bowling stats not found with id: " + bowlingStatsId));
    }

    @Override
    public List<BowlingStats> getAllBowlingStats() {
        return bowlingStatsRepository.findAll();
    }

    @Override
    public List<BowlingStats> getBowlingStatsByMatch(Integer matchId) {
        return bowlingStatsRepository.findByMatchMatchId(matchId);
    }

    @Override
    public List<BowlingStats> getBowlingStatsByPlayer(Integer playerId) {
        return bowlingStatsRepository.findByPlayerPlayerId(playerId);
    }

    @Override
    public List<BowlingStats> getBowlingStatsByTeam(Integer teamId) {
        return bowlingStatsRepository.findByTeamTeamId(teamId);
    }

    @Override
    public List<BowlingStats> getBowlingStatsByMatchAndTeam(Integer matchId, Integer teamId) {
        return bowlingStatsRepository.findByMatchMatchIdAndTeamTeamId(matchId, teamId);
    }

    @Override
    public List<BowlingStats> getBowlingStatsByMatchAndInnings(Integer matchId, Integer innings) {
        return bowlingStatsRepository.findByMatchMatchIdAndInnings(matchId, innings);
    }

    @Override
    public BowlingStats updateBowlingStats(Integer bowlingStatsId, BowlingStats bowlingStats) {
        BowlingStats existingBowlingStats = getBowlingStatsById(bowlingStatsId);
        existingBowlingStats.setMatch(bowlingStats.getMatch());
        existingBowlingStats.setInningsScorecard(bowlingStats.getInningsScorecard());
        existingBowlingStats.setPlayer(bowlingStats.getPlayer());
        existingBowlingStats.setTeam(bowlingStats.getTeam());
        existingBowlingStats.setInnings(bowlingStats.getInnings());
        existingBowlingStats.setOvers(bowlingStats.getOvers());
        existingBowlingStats.setMaidens(bowlingStats.getMaidens());
        existingBowlingStats.setRunsConceded(bowlingStats.getRunsConceded());
        existingBowlingStats.setWickets(bowlingStats.getWickets());
        existingBowlingStats.setEcon(bowlingStats.getEcon());
        existingBowlingStats.setWides(bowlingStats.getWides());
        existingBowlingStats.setNoBalls(bowlingStats.getNoBalls());
        return bowlingStatsRepository.save(existingBowlingStats);
    }

    @Override
    public void deleteBowlingStats(Integer bowlingStatsId) {
        bowlingStatsRepository.deleteById(bowlingStatsId);
    }
} 