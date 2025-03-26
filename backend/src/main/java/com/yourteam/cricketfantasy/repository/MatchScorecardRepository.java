package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import com.yourteam.cricketfantasy.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatchScorecardRepository extends JpaRepository<InningsScorecard, Integer> {
    List<InningsScorecard> findByMatchMatchId(Integer matchId);
    List<InningsScorecard> findByTeam(Team team);
    List<InningsScorecard> findByMatchMatchIdAndTeamTeamId(Integer matchId, Integer teamId);
    List<InningsScorecard> findByMatchMatchIdAndInnings(Integer matchId, Integer innings);
} 