package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.BattingStats;
import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.repository.PlayerScoresRepository;
import com.yourteam.cricketfantasy.service.PlayerScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PlayerScoresServiceImpl implements PlayerScoresService {

    @Autowired
    private PlayerScoresRepository playerScoresRepository;

    @Override
    @Transactional
    public BattingStats createPlayerScores(BattingStats playerScores) {
        return playerScoresRepository.save(playerScores);
    }

    @Override
    public BattingStats getPlayerScoresById(Integer playerScoreId) {
        return playerScoresRepository.findById(playerScoreId)
                .orElseThrow(() -> new RuntimeException("Player Scores not found with id: " + playerScoreId));
    }

    @Override
    public List<BattingStats> getAllPlayerScores() {
        return playerScoresRepository.findAll();
    }

    @Override
    public List<BattingStats> getPlayerScoresByMatch(Integer matchId) {
        return playerScoresRepository.findByMatchMatchId(matchId);
    }

    @Override
    public List<BattingStats> getPlayerScoresByPlayer(Player player) {
        return playerScoresRepository.findByPlayer(player);
    }

    @Override
    public List<BattingStats> getPlayerScoresByTeam(Team team) {
        return playerScoresRepository.findByTeam(team);
    }

    @Override
    public List<BattingStats> getPlayerScoresByMatchAndTeam(Integer matchId, Integer teamId) {
        return playerScoresRepository.findByMatchMatchIdAndTeamTeamId(matchId, teamId);
    }

    @Override
    public List<BattingStats> getPlayerScoresByMatchAndInnings(Integer matchId, Integer innings) {
        return playerScoresRepository.findByMatchMatchIdAndInnings(matchId, innings);
    }

    @Override
    public List<BattingStats> getPlayerScoresByBowler(Player bowler) {
        return playerScoresRepository.findByBowler(bowler);
    }

    @Override
    @Transactional
    public BattingStats updatePlayerScores(Integer playerScoreId, BattingStats playerScores) {
        BattingStats existingScores = getPlayerScoresById(playerScoreId);
        // Update fields
        existingScores.setMatch(playerScores.getMatch());
        existingScores.setPlayer(playerScores.getPlayer());
        existingScores.setTeam(playerScores.getTeam());
        existingScores.setInnings(playerScores.getInnings());
        existingScores.setBattingPosition(playerScores.getBattingPosition());
        existingScores.setRunsScored(playerScores.getRunsScored());
        existingScores.setBallsFaced(playerScores.getBallsFaced());
        existingScores.setFours(playerScores.getFours());
        existingScores.setSixes(playerScores.getSixes());
        existingScores.setStrikeRate(playerScores.getStrikeRate());
        existingScores.setBowler(playerScores.getBowler());
        existingScores.setDismissalType(playerScores.getDismissalType());
        return playerScoresRepository.save(existingScores);
    }

    @Override
    @Transactional
    public void deletePlayerScores(Integer playerScoreId) {
        playerScoresRepository.deleteById(playerScoreId);
    }
} 