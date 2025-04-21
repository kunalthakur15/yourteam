package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.BattingStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BattingStatsRepository extends JpaRepository<BattingStats, Integer> {
    List<BattingStats> findByTeamTeamId(Integer teamId);
    List<BattingStats> findByMatchMatchId(Integer matchId);
    List<BattingStats> findByMatchMatchIdAndTeamTeamId(Integer matchId, Integer teamId);
    List<BattingStats> findByPlayerPlayerId(Integer playerId);
    List<BattingStats> findByMatchMatchIdAndInnings(Integer matchId, Integer innings);
} 