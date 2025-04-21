package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Match;
import com.yourteam.cricketfantasy.repository.MatchRepository;
import com.yourteam.cricketfantasy.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match getMatchById(Integer matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + matchId));
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match updateMatch(Integer matchId, Match match) {
        Match existingMatch = getMatchById(matchId);
        existingMatch.setTournament(match.getTournament());
        existingMatch.setInningsScorecards(match.getInningsScorecards());
        existingMatch.setMatchDate(match.getMatchDate());
        existingMatch.setMatchYear(match.getMatchYear());
        existingMatch.setVenue(match.getVenue());
        existingMatch.setVenueCity(match.getVenueCity());
        existingMatch.setTeam1(match.getTeam1());
        existingMatch.setTeam1Captain(match.getTeam1Captain());
        existingMatch.setTeam2(match.getTeam2());
        existingMatch.setTeam2Captain(match.getTeam2Captain());
        existingMatch.setTossWinner(match.getTossWinner());
        existingMatch.setTossDecision(match.getTossDecision());
        existingMatch.setWasSuperOver(match.getWasSuperOver());
        existingMatch.setWinningTeam(match.getWinningTeam());
        existingMatch.setWonBy(match.getWonBy());
        existingMatch.setWinMargin(match.getWinMargin());
        existingMatch.setManOfTheMatch(match.getManOfTheMatch());
        existingMatch.setUmpire1(match.getUmpire1());
        existingMatch.setUmpire2(match.getUmpire2());
        existingMatch.setMatchType(match.getMatchType());
        return matchRepository.save(existingMatch);
    }

    @Override
    public void deleteMatch(Integer matchId) {
        matchRepository.deleteById(matchId);
    }

    @Override
    public List<Match> getMatchesByTournament(Integer tournamentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMatchesByTournament'");
    }

    @Override
    public List<Match> getMatchesByTeam(Integer teamId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMatchesByTeam'");
    }

    @Override
    public List<Match> getMatchesByDate(String date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMatchesByDate'");
    }
} 