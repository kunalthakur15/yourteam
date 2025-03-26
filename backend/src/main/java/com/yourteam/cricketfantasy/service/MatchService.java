package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.Match;
import com.yourteam.cricketfantasy.model.MatchType;
import com.yourteam.cricketfantasy.model.Team;
import java.time.LocalDate;
import java.util.List;

public interface MatchService {
    Match createMatch(Match match);
    Match getMatchById(Integer matchId);
    List<Match> getAllMatches();
    List<Match> getMatchesByTournament(Integer tournamentId);
    List<Match> getMatchesByTeam(Team team);
    List<Match> getMatchesByDateRange(LocalDate startDate, LocalDate endDate);
    List<Match> getMatchesByType(MatchType matchType);
    List<Match> getMatchesByWinningTeam(Team winningTeam);
    Match updateMatch(Integer matchId, Match match);
    void deleteMatch(Integer matchId);
} 