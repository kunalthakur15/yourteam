package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.FallOfWickets;
import com.yourteam.cricketfantasy.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FallOfWicketsRepository extends JpaRepository<FallOfWickets, Integer> {
    List<FallOfWickets> findByMatchMatchId(Integer matchId);
    List<FallOfWickets> findByTeam(Team team);
    List<FallOfWickets> findByMatchMatchIdAndTeamTeamId(Integer matchId, Integer teamId);
    List<FallOfWickets> findByMatchMatchIdAndInnings(Integer matchId, Integer innings);
} 