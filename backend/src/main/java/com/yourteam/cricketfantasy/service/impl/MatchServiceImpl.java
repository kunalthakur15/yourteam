package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Match;
import com.yourteam.cricketfantasy.model.MatchType;
import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.repository.MatchRepository;
import com.yourteam.cricketfantasy.service.MatchService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Override
    @Transactional
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match getMatchById(Integer matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with id: " + matchId));
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<Match> getMatchesByTournament(Integer tournamentId) {
        return matchRepository.findByTournamentTournamentId(tournamentId);
    }

    @Override
    public List<Match> getMatchesByTeam(Team team) {
        return matchRepository.findByTeam1OrTeam2(team, team);
    }

    @Override
    public List<Match> getMatchesByDateRange(LocalDate startDate, LocalDate endDate) {
        return matchRepository.findByMatchDateBetween(startDate, endDate);
    }

    @Override
    public List<Match> getMatchesByType(MatchType matchType) {
        return matchRepository.findByMatchType(matchType);
    }

    @Override
    public List<Match> getMatchesByWinningTeam(Team winningTeam) {
        return matchRepository.findByWinningTeam(winningTeam);
    }

    @Override
    @Transactional
    public Match updateMatch(Integer matchId, Match matchDetails) {
        Match match = getMatchById(matchId);
        match.setTournament(matchDetails.getTournament());
        match.setMatchDate(matchDetails.getMatchDate());
        match.setMatchYear(matchDetails.getMatchYear());
        match.setVenue(matchDetails.getVenue());
        match.setVenueCity(matchDetails.getVenueCity());
        match.setTeam1(matchDetails.getTeam1());
        match.setTeam1Captain(matchDetails.getTeam1Captain());
        match.setTeam2(matchDetails.getTeam2());
        match.setTeam2Captain(matchDetails.getTeam2Captain());
        match.setTossWinner(matchDetails.getTossWinner());
        match.setTossDecision(matchDetails.getTossDecision());
        match.setWasSuperOver(matchDetails.getWasSuperOver());
        match.setWinningTeam(matchDetails.getWinningTeam());
        match.setWonBy(matchDetails.getWonBy());
        match.setWinMargin(matchDetails.getWinMargin());
        match.setManOfTheMatch(matchDetails.getManOfTheMatch());
        match.setUmpire1(matchDetails.getUmpire1());
        match.setUmpire2(matchDetails.getUmpire2());
        match.setMatchType(matchDetails.getMatchType());
        return matchRepository.save(match);
    }

    @Override
    @Transactional
    public void deleteMatch(Integer matchId) {
        Match match = getMatchById(matchId);
        matchRepository.delete(match);
    }
} 