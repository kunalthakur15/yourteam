package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Tournament;
import com.yourteam.cricketfantasy.repository.TournamentRepository;
import com.yourteam.cricketfantasy.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Override
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public Tournament getTournamentById(Integer tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found with id: " + tournamentId));
    }

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament updateTournament(Integer tournamentId, Tournament tournament) {
        Tournament existingTournament = getTournamentById(tournamentId);
        existingTournament.setTournamentName(tournament.getTournamentName());
        existingTournament.setYear(tournament.getYear());
        existingTournament.setLocation(tournament.getLocation());
        existingTournament.setMatches(tournament.getMatches());
        existingTournament.setTeams(tournament.getTeams());
        return tournamentRepository.save(existingTournament);
    }

    @Override
    public void deleteTournament(Integer tournamentId) {
        tournamentRepository.deleteById(tournamentId);
    }
} 