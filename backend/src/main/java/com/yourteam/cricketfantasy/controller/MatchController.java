package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.Match;
import com.yourteam.cricketfantasy.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Match Management", description = "APIs for managing cricket matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    @Operation(summary = "Create a new match")
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        return ResponseEntity.ok(matchService.createMatch(match));
    }

    @GetMapping("/{matchId}")
    @Operation(summary = "Get a match by ID")
    public ResponseEntity<Match> getMatchById(@PathVariable Integer matchId) {
        return ResponseEntity.ok(matchService.getMatchById(matchId));
    }

    @GetMapping
    @Operation(summary = "Get all matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @PutMapping("/{matchId}")
    @Operation(summary = "Update a match")
    public ResponseEntity<Match> updateMatch(@PathVariable Integer matchId, @RequestBody Match match) {
        return ResponseEntity.ok(matchService.updateMatch(matchId, match));
    }

    @DeleteMapping("/{matchId}")
    @Operation(summary = "Delete a match")
    public ResponseEntity<Void> deleteMatch(@PathVariable Integer matchId) {
        matchService.deleteMatch(matchId);
        return ResponseEntity.ok().build();
    }
} 