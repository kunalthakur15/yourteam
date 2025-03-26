package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.BattingStats;
import com.yourteam.cricketfantasy.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerScoresRepository extends JpaRepository<BattingStats, Integer> {
    List<BattingStats> findByMatchMatchId(Integer matchId);
    List<BattingStats> findByPlayer(Player player);
    List<BattingStats> findByTeam(Team team);
    List<BattingStats> findByMatchMatchIdAndTeamTeamId(Integer matchId, Integer teamId);
    List<BattingStats> findByMatchMatchIdAndInnings(Integer matchId, Integer innings);
    List<BattingStats> findByBowler(Player bowler);
} 