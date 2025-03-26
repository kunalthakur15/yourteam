package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.service.MatchScorecardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/match-scorecards")
@Tag(name = "Match Scorecard", description = "API endpoints for managing match scorecards")
public class MatchScorecardController {

    @Autowired
    private MatchScorecardService matchScorecardService;

    @PostMapping
    @Operation(summary = "Create a new match scorecard")
    public ResponseEntity<InningsScorecard> createMatchScorecard(@RequestBody InningsScorecard matchScorecard) {
        return ResponseEntity.ok(matchScorecardService.createMatchScorecard(matchScorecard));
    }

    @GetMapping("/{scorecardId}")
    @Operation(summary = "Get a match scorecard by ID")
    public ResponseEntity<InningsScorecard> getMatchScorecardById(
            @Parameter(description = "ID of the match scorecard") @PathVariable Integer scorecardId) {
        return ResponseEntity.ok(matchScorecardService.getMatchScorecardById(scorecardId));
    }

    @GetMapping
    @Operation(summary = "Get all match scorecards")
    public ResponseEntity<List<InningsScorecard>> getAllMatchScorecards() {
        return ResponseEntity.ok(matchScorecardService.getAllMatchScorecards());
    }

    @GetMapping("/match/{matchId}")
    @Operation(summary = "Get match scorecards by match ID")
    public ResponseEntity<List<InningsScorecard>> getMatchScorecardsByMatch(
            @Parameter(description = "ID of the match") @PathVariable Integer matchId) {
        return ResponseEntity.ok(matchScorecardService.getMatchScorecardsByMatch(matchId));
    }

    @GetMapping("/team/{teamId}")
    @Operation(summary = "Get match scorecards by team ID")
    public ResponseEntity<List<InningsScorecard>> getMatchScorecardsByTeam(
            @Parameter(description = "ID of the team") @PathVariable Integer teamId) {
        Team team = new Team();
        team.setTeamId(teamId);
        return ResponseEntity.ok(matchScorecardService.getMatchScorecardsByTeam(team));
    }

    @GetMapping("/match/{matchId}/team/{teamId}")
    @Operation(summary = "Get match scorecards by match and team IDs")
    public ResponseEntity<List<InningsScorecard>> getMatchScorecardsByMatchAndTeam(
            @Parameter(description = "ID of the match") @PathVariable Integer matchId,
            @Parameter(description = "ID of the team") @PathVariable Integer teamId) {
        return ResponseEntity.ok(matchScorecardService.getMatchScorecardsByMatchAndTeam(matchId, teamId));
    }

    @GetMapping("/match/{matchId}/innings/{innings}")
    @Operation(summary = "Get match scorecards by match ID and innings number")
    public ResponseEntity<List<InningsScorecard>> getMatchScorecardsByMatchAndInnings(
            @Parameter(description = "ID of the match") @PathVariable Integer matchId,
            @Parameter(description = "Innings number") @PathVariable Integer innings) {
        return ResponseEntity.ok(matchScorecardService.getMatchScorecardsByMatchAndInnings(matchId, innings));
    }

    @PutMapping("/{scorecardId}")
    @Operation(summary = "Update a match scorecard")
    public ResponseEntity<InningsScorecard> updateMatchScorecard(
            @Parameter(description = "ID of the match scorecard") @PathVariable Integer scorecardId,
            @RequestBody InningsScorecard matchScorecard) {
        return ResponseEntity.ok(matchScorecardService.updateMatchScorecard(scorecardId, matchScorecard));
    }

    @DeleteMapping("/{scorecardId}")
    @Operation(summary = "Delete a match scorecard")
    public ResponseEntity<Void> deleteMatchScorecard(
            @Parameter(description = "ID of the match scorecard") @PathVariable Integer scorecardId) {
        matchScorecardService.deleteMatchScorecard(scorecardId);
        return ResponseEntity.ok().build();
    }
} 