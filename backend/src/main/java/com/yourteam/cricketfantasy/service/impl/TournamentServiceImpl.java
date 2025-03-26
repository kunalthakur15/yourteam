package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Tournament;
import com.yourteam.cricketfantasy.repository.TournamentRepository;
import com.yourteam.cricketfantasy.service.TournamentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Year;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;

    @Override
    @Transactional
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public Tournament getTournamentById(Integer tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("Tournament not found with id: " + tournamentId));
    }

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public List<Tournament> getTournamentsByYear(Year year) {
        return tournamentRepository.findByYear(year);
    }

    @Override
    @Transactional
    public Tournament updateTournament(Integer tournamentId, Tournament tournamentDetails) {
        Tournament tournament = getTournamentById(tournamentId);
        tournament.setTournamentName(tournamentDetails.getTournamentName());
        tournament.setYear(tournamentDetails.getYear());
        tournament.setLocation(tournamentDetails.getLocation());
        return tournamentRepository.save(tournament);
    }

    @Override
    @Transactional
    public void deleteTournament(Integer tournamentId) {
        Tournament tournament = getTournamentById(tournamentId);
        tournamentRepository.delete(tournament);
    }
} 