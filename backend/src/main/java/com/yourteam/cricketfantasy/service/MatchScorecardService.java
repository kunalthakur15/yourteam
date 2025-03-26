package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import com.yourteam.cricketfantasy.model.Team;
import java.util.List;

public interface MatchScorecardService {
    InningsScorecard createMatchScorecard(InningsScorecard matchScorecard);
    InningsScorecard getMatchScorecardById(Integer scorecardId);
    List<InningsScorecard> getAllMatchScorecards();
    List<InningsScorecard> getMatchScorecardsByMatch(Integer matchId);
    List<InningsScorecard> getMatchScorecardsByTeam(Team team);
    List<InningsScorecard> getMatchScorecardsByMatchAndTeam(Integer matchId, Integer teamId);
    List<InningsScorecard> getMatchScorecardsByMatchAndInnings(Integer matchId, Integer innings);
    InningsScorecard updateMatchScorecard(Integer scorecardId, InningsScorecard matchScorecard);
    void deleteMatchScorecard(Integer scorecardId);
} 