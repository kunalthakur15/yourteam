package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import java.util.List;

public interface InningsScorecardService {
    InningsScorecard createInningsScorecard(InningsScorecard inningsScorecard);
    InningsScorecard getInningsScorecardById(Integer inningsScorecardId);
    List<InningsScorecard> getAllInningsScorecards();
    List<InningsScorecard> getInningsScorecardsByMatch(Integer matchId);
    List<InningsScorecard> getInningsScorecardsByTeam(Integer teamId);
    List<InningsScorecard> getInningsScorecardsByMatchAndTeam(Integer matchId, Integer teamId);
    InningsScorecard getInningsScorecardByMatchAndInnings(Integer matchId, Integer innings);
    InningsScorecard updateInningsScorecard(Integer inningsScorecardId, InningsScorecard inningsScorecard);
    void deleteInningsScorecard(Integer inningsScorecardId);
} 