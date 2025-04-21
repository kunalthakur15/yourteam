package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import com.yourteam.cricketfantasy.repository.InningsScorecardRepository;
import com.yourteam.cricketfantasy.service.InningsScorecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InningsScorecardServiceImpl implements InningsScorecardService {

    @Autowired
    private InningsScorecardRepository inningsScorecardRepository;

    @Override
    public InningsScorecard createInningsScorecard(InningsScorecard inningsScorecard) {
        return inningsScorecardRepository.save(inningsScorecard);
    }

    @Override
    public InningsScorecard getInningsScorecardById(Integer inningsScorecardId) {
        return inningsScorecardRepository.findById(inningsScorecardId)
                .orElseThrow(() -> new RuntimeException("Innings scorecard not found with id: " + inningsScorecardId));
    }

    @Override
    public List<InningsScorecard> getAllInningsScorecards() {
        return inningsScorecardRepository.findAll();
    }

    @Override
    public InningsScorecard updateInningsScorecard(Integer inningsScorecardId, InningsScorecard inningsScorecard) {
        InningsScorecard existingInningsScorecard = getInningsScorecardById(inningsScorecardId);
        existingInningsScorecard.setMatch(inningsScorecard.getMatch());
        existingInningsScorecard.setBattingStats(inningsScorecard.getBattingStats());
        existingInningsScorecard.setBowlingStats(inningsScorecard.getBowlingStats());
        existingInningsScorecard.setRuns(inningsScorecard.getRuns());
        existingInningsScorecard.setWickets(inningsScorecard.getWickets());
        existingInningsScorecard.setOvers(inningsScorecard.getOvers());
        existingInningsScorecard.setExtras(inningsScorecard.getExtras());
        return inningsScorecardRepository.save(existingInningsScorecard);
    }

    @Override
    public void deleteInningsScorecard(Integer inningsScorecardId) {
        inningsScorecardRepository.deleteById(inningsScorecardId);
    }

    @Override
    public InningsScorecard getInningsScorecardByMatchAndInnings(Integer matchId, Integer innings) {
        return inningsScorecardRepository.findByMatchMatchIdAndInnings(matchId, innings).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Innings scorecard not found for match: " + matchId + " and innings: " + innings));
    }

    @Override
    public List<InningsScorecard> getInningsScorecardsByMatch(Integer matchId) {
        return inningsScorecardRepository.findByMatchMatchId(matchId);
    }

    @Override
    public List<InningsScorecard> getInningsScorecardsByTeam(Integer teamId) {
        return inningsScorecardRepository.findByTeamTeamId(teamId);
    }

    @Override
    public List<InningsScorecard> getInningsScorecardsByMatchAndTeam(Integer matchId, Integer teamId) {
        return inningsScorecardRepository.findByMatchMatchIdAndTeamTeamId(matchId, teamId);
    }
} 