package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InningsScorecardRepository extends JpaRepository<InningsScorecard, Integer> {
    Optional<InningsScorecard> findByMatchIdAndInningNumber(Integer matchId, Integer inningNumber);
    List<InningsScorecard> findByMatchId(Integer matchId);
} 