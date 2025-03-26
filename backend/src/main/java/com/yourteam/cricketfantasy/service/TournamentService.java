package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.Tournament;
import java.time.Year;
import java.util.List;

public interface TournamentService {
    Tournament createTournament(Tournament tournament);
    Tournament getTournamentById(Integer tournamentId);
    List<Tournament> getAllTournaments();
    List<Tournament> getTournamentsByYear(Year year);
    Tournament updateTournament(Integer tournamentId, Tournament tournament);
    void deleteTournament(Integer tournamentId);
} 