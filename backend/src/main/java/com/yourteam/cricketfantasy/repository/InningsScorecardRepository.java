package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InningsScorecardRepository extends JpaRepository<InningsScorecard, Integer> {
    List<InningsScorecard> findByMatchMatchIdAndInnings(Integer matchId, Integer innings);
    List<InningsScorecard> findByMatchMatchId(Integer matchId);
    List<InningsScorecard> findByMatchMatchIdAndTeamTeamId(Integer matchId, Integer teamId);
    List<InningsScorecard> findByTeamTeamId(Integer teamId);
} 