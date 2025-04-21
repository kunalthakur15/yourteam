package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.BowlingStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BowlingStatsRepository extends JpaRepository<BowlingStats, Integer> {
    List<BowlingStats> findByMatchMatchId(Integer matchId);
    List<BowlingStats> findByPlayerPlayerId(Integer playerId);
    List<BowlingStats> findByTeamTeamId(Integer teamId);
    List<BowlingStats> findByMatchMatchIdAndTeamTeamId(Integer matchId, Integer teamId);
    List<BowlingStats> findByMatchMatchIdAndInnings(Integer matchId, Integer innings);
} 