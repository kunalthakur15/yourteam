package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.repository.MatchScorecardRepository;
import com.yourteam.cricketfantasy.service.MatchScorecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MatchScorecardServiceImpl implements MatchScorecardService {

    @Autowired
    private MatchScorecardRepository matchScorecardRepository;

    @Override
    @Transactional
    public InningsScorecard createMatchScorecard(InningsScorecard matchScorecard) {
        return matchScorecardRepository.save(matchScorecard);
    }

    @Override
    public InningsScorecard getMatchScorecardById(Integer scorecardId) {
        return matchScorecardRepository.findById(scorecardId)
                .orElseThrow(() -> new RuntimeException("Match Scorecard not found with id: " + scorecardId));
    }

    @Override
    public List<InningsScorecard> getAllMatchScorecards() {
        return matchScorecardRepository.findAll();
    }

    @Override
    public List<InningsScorecard> getMatchScorecardsByMatch(Integer matchId) {
        return matchScorecardRepository.findByMatchMatchId(matchId);
    }

    @Override
    public List<InningsScorecard> getMatchScorecardsByTeam(Team team) {
        return matchScorecardRepository.findByTeam(team);
    }

    @Override
    public List<InningsScorecard> getMatchScorecardsByMatchAndTeam(Integer matchId, Integer teamId) {
        return matchScorecardRepository.findByMatchMatchIdAndTeamTeamId(matchId, teamId);
    }

    @Override
    public List<InningsScorecard> getMatchScorecardsByMatchAndInnings(Integer matchId, Integer innings) {
        return matchScorecardRepository.findByMatchMatchIdAndInnings(matchId, innings);
    }

    @Override
    @Transactional
    public InningsScorecard updateMatchScorecard(Integer scorecardId, InningsScorecard matchScorecard) {
        InningsScorecard existingScorecard = getMatchScorecardById(scorecardId);
        // Update fields
        existingScorecard.setMatch(matchScorecard.getMatch());
        existingScorecard.setTeam(matchScorecard.getTeam());
        existingScorecard.setInnings(matchScorecard.getInnings());
        existingScorecard.setRuns(matchScorecard.getRuns());
        existingScorecard.setWickets(matchScorecard.getWickets());
        existingScorecard.setOvers(matchScorecard.getOvers());
        existingScorecard.setExtras(matchScorecard.getExtras());
        return matchScorecardRepository.save(existingScorecard);
    }

    @Override
    @Transactional
    public void deleteMatchScorecard(Integer scorecardId) {
        matchScorecardRepository.deleteById(scorecardId);
    }
} 