package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.Tournament;
import com.yourteam.cricketfantasy.service.TournamentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
@RequiredArgsConstructor
@Tag(name = "Tournament Management", description = "APIs for managing cricket tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @PostMapping
    @Operation(summary = "Create a new tournament")
    public ResponseEntity<Tournament> createTournament(@Valid @RequestBody Tournament tournament) {
        return new ResponseEntity<>(tournamentService.createTournament(tournament), HttpStatus.CREATED);
    }

    @GetMapping("/{tournamentId}")
    @Operation(summary = "Get tournament by ID")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Integer tournamentId) {
        return ResponseEntity.ok(tournamentService.getTournamentById(tournamentId));
    }

    @GetMapping
    @Operation(summary = "Get all tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @GetMapping("/year/{year}")
    @Operation(summary = "Get tournaments by year")
    public ResponseEntity<List<Tournament>> getTournamentsByYear(@PathVariable Year year) {
        return ResponseEntity.ok(tournamentService.getTournamentsByYear(year));
    }

    @PutMapping("/{tournamentId}")
    @Operation(summary = "Update tournament")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Integer tournamentId, @Valid @RequestBody Tournament tournament) {
        return ResponseEntity.ok(tournamentService.updateTournament(tournamentId, tournament));
    }

    @DeleteMapping("/{tournamentId}")
    @Operation(summary = "Delete tournament")
    public ResponseEntity<Void> deleteTournament(@PathVariable Integer tournamentId) {
        tournamentService.deleteTournament(tournamentId);
        return ResponseEntity.noContent().build();
    }
} 