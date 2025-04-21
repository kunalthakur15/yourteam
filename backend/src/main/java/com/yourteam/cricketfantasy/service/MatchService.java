package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.Match;
import java.util.List;

public interface MatchService {
    Match createMatch(Match match);
    Match getMatchById(Integer matchId);
    List<Match> getAllMatches();
    List<Match> getMatchesByTournament(Integer tournamentId);
    List<Match> getMatchesByTeam(Integer teamId);
    List<Match> getMatchesByDate(String date);
    Match updateMatch(Integer matchId, Match match);
    void deleteMatch(Integer matchId);
} 