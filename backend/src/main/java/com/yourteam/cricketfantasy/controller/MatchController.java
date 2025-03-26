package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.Match;
import com.yourteam.cricketfantasy.model.MatchType;
import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
@Tag(name = "Match Management", description = "APIs for managing cricket matches")
public class MatchController {

    private final MatchService matchService;

    @PostMapping
    @Operation(summary = "Create a new match")
    public ResponseEntity<Match> createMatch(@Valid @RequestBody Match match) {
        return new ResponseEntity<>(matchService.createMatch(match), HttpStatus.CREATED);
    }

    @GetMapping("/{matchId}")
    @Operation(summary = "Get match by ID")
    public ResponseEntity<Match> getMatchById(@PathVariable Integer matchId) {
        return ResponseEntity.ok(matchService.getMatchById(matchId));
    }

    @GetMapping
    @Operation(summary = "Get all matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/tournament/{tournamentId}")
    @Operation(summary = "Get matches by tournament")
    public ResponseEntity<List<Match>> getMatchesByTournament(@PathVariable Integer tournamentId) {
        return ResponseEntity.ok(matchService.getMatchesByTournament(tournamentId));
    }

    @GetMapping("/team/{teamId}")
    @Operation(summary = "Get matches by team")
    public ResponseEntity<List<Match>> getMatchesByTeam(@PathVariable Integer teamId) {
        Team team = new Team();
        team.setTeamId(teamId);
        return ResponseEntity.ok(matchService.getMatchesByTeam(team));
    }

    @GetMapping("/date-range")
    @Operation(summary = "Get matches by date range")
    public ResponseEntity<List<Match>> getMatchesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(matchService.getMatchesByDateRange(startDate, endDate));
    }

    @GetMapping("/type/{matchType}")
    @Operation(summary = "Get matches by type")
    public ResponseEntity<List<Match>> getMatchesByType(@PathVariable MatchType matchType) {
        return ResponseEntity.ok(matchService.getMatchesByType(matchType));
    }

    @GetMapping("/winning-team/{teamId}")
    @Operation(summary = "Get matches by winning team")
    public ResponseEntity<List<Match>> getMatchesByWinningTeam(@PathVariable Integer teamId) {
        Team team = new Team();
        team.setTeamId(teamId);
        return ResponseEntity.ok(matchService.getMatchesByWinningTeam(team));
    }

    @PutMapping("/{matchId}")
    @Operation(summary = "Update match")
    public ResponseEntity<Match> updateMatch(@PathVariable Integer matchId, @Valid @RequestBody Match match) {
        return ResponseEntity.ok(matchService.updateMatch(matchId, match));
    }

    @DeleteMapping("/{matchId}")
    @Operation(summary = "Delete match")
    public ResponseEntity<Void> deleteMatch(@PathVariable Integer matchId) {
        matchService.deleteMatch(matchId);
        return ResponseEntity.noContent().build();
    }
} 