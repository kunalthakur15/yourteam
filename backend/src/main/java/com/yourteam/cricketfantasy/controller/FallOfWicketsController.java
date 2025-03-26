package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.FallOfWickets;
import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.service.FallOfWicketsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fall-of-wickets")
@Tag(name = "Fall of Wickets", description = "API endpoints for managing fall of wickets")
public class FallOfWicketsController {

    @Autowired
    private FallOfWicketsService fallOfWicketsService;

    @PostMapping
    @Operation(summary = "Create new fall of wickets record")
    public ResponseEntity<FallOfWickets> createFallOfWickets(@RequestBody FallOfWickets fallOfWickets) {
        return ResponseEntity.ok(fallOfWicketsService.createFallOfWickets(fallOfWickets));
    }

    @GetMapping("/{fallOfWicketId}")
    @Operation(summary = "Get fall of wickets by ID")
    public ResponseEntity<FallOfWickets> getFallOfWicketsById(
            @Parameter(description = "ID of the fall of wickets record") @PathVariable Integer fallOfWicketId) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsById(fallOfWicketId));
    }

    @GetMapping
    @Operation(summary = "Get all fall of wickets records")
    public ResponseEntity<List<FallOfWickets>> getAllFallOfWickets() {
        return ResponseEntity.ok(fallOfWicketsService.getAllFallOfWickets());
    }

    @GetMapping("/match/{matchId}")
    @Operation(summary = "Get fall of wickets by match ID")
    public ResponseEntity<List<FallOfWickets>> getFallOfWicketsByMatch(
            @Parameter(description = "ID of the match") @PathVariable Integer matchId) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsByMatch(matchId));
    }

    @GetMapping("/team/{teamId}")
    @Operation(summary = "Get fall of wickets by team ID")
    public ResponseEntity<List<FallOfWickets>> getFallOfWicketsByTeam(
            @Parameter(description = "ID of the team") @PathVariable Integer teamId) {
        Team team = new Team();
        team.setTeamId(teamId);
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsByTeam(team));
    }

    @GetMapping("/match/{matchId}/team/{teamId}")
    @Operation(summary = "Get fall of wickets by match and team IDs")
    public ResponseEntity<List<FallOfWickets>> getFallOfWicketsByMatchAndTeam(
            @Parameter(description = "ID of the match") @PathVariable Integer matchId,
            @Parameter(description = "ID of the team") @PathVariable Integer teamId) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsByMatchAndTeam(matchId, teamId));
    }

    @GetMapping("/match/{matchId}/innings/{innings}")
    @Operation(summary = "Get fall of wickets by match ID and innings number")
    public ResponseEntity<List<FallOfWickets>> getFallOfWicketsByMatchAndInnings(
            @Parameter(description = "ID of the match") @PathVariable Integer matchId,
            @Parameter(description = "Innings number") @PathVariable Integer innings) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsByMatchAndInnings(matchId, innings));
    }

    @PutMapping("/{fallOfWicketId}")
    @Operation(summary = "Update fall of wickets record")
    public ResponseEntity<FallOfWickets> updateFallOfWickets(
            @Parameter(description = "ID of the fall of wickets record") @PathVariable Integer fallOfWicketId,
            @RequestBody FallOfWickets fallOfWickets) {
        return ResponseEntity.ok(fallOfWicketsService.updateFallOfWickets(fallOfWicketId, fallOfWickets));
    }

    @DeleteMapping("/{fallOfWicketId}")
    @Operation(summary = "Delete fall of wickets record")
    public ResponseEntity<Void> deleteFallOfWickets(
            @Parameter(description = "ID of the fall of wickets record") @PathVariable Integer fallOfWicketId) {
        fallOfWicketsService.deleteFallOfWickets(fallOfWicketId);
        return ResponseEntity.ok().build();
    }
} 