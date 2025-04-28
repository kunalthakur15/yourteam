package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.BattingStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BattingStatsRepository extends JpaRepository<BattingStats, Integer> {
    List<BattingStats> findByPlayerId(Integer playerId);
} 