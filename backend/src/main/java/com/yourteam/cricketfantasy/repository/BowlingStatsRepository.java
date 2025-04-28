package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.BowlingStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BowlingStatsRepository extends JpaRepository<BowlingStats, Integer> {
    List<BowlingStats> findByPlayerId(Integer playerId);
} 