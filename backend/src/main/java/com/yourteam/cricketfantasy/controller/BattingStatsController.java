package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.BattingStats;
import com.yourteam.cricketfantasy.service.BattingStatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batting-stats")
@Tag(name = "Batting Statistics Management", description = "APIs for managing batting statistics")
public class BattingStatsController {

    @Autowired
    private BattingStatsService battingStatsService;

    @PostMapping
    @Operation(summary = "Create new batting statistics")
    public ResponseEntity<BattingStats> createBattingStats(@RequestBody BattingStats battingStats) {
        return ResponseEntity.ok(battingStatsService.createBattingStats(battingStats));
    }

    @GetMapping("/{battingStatsId}")
    @Operation(summary = "Get batting statistics by ID")
    public ResponseEntity<BattingStats> getBattingStatsById(@PathVariable Integer battingStatsId) {
        return ResponseEntity.ok(battingStatsService.getBattingStatsById(battingStatsId));
    }

    @GetMapping
    @Operation(summary = "Get all batting statistics")
    public ResponseEntity<List<BattingStats>> getAllBattingStats() {
        return ResponseEntity.ok(battingStatsService.getAllBattingStats());
    }

    @GetMapping("/match/{matchId}")
    @Operation(summary = "Get batting statistics by match ID")
    public ResponseEntity<List<BattingStats>> getBattingStatsByMatch(@PathVariable Integer matchId) {
        return ResponseEntity.ok(battingStatsService.getBattingStatsByMatch(matchId));
    }

    @GetMapping("/player/{playerId}")
    @Operation(summary = "Get batting statistics by player ID")
    public ResponseEntity<List<BattingStats>> getBattingStatsByPlayer(@PathVariable Integer playerId) {
        return ResponseEntity.ok(battingStatsService.getBattingStatsByPlayer(playerId));
    }

    @GetMapping("/team/{teamId}")
    @Operation(summary = "Get batting statistics by team ID")
    public ResponseEntity<List<BattingStats>> getBattingStatsByTeam(@PathVariable Integer teamId) {
        return ResponseEntity.ok(battingStatsService.getBattingStatsByTeam(teamId));
    }

    @GetMapping("/match/{matchId}/team/{teamId}")
    @Operation(summary = "Get batting statistics by match ID and team ID")
    public ResponseEntity<List<BattingStats>> getBattingStatsByMatchAndTeam(
            @PathVariable Integer matchId,
            @PathVariable Integer teamId) {
        return ResponseEntity.ok(battingStatsService.getBattingStatsByMatchAndTeam(matchId, teamId));
    }

    @GetMapping("/match/{matchId}/innings/{innings}")
    @Operation(summary = "Get batting statistics by match ID and innings")
    public ResponseEntity<List<BattingStats>> getBattingStatsByMatchAndInnings(
            @PathVariable Integer matchId,
            @PathVariable Integer innings) {
        return ResponseEntity.ok(battingStatsService.getBattingStatsByMatchAndInnings(matchId, innings));
    }

    @PutMapping("/{battingStatsId}")
    @Operation(summary = "Update batting statistics")
    public ResponseEntity<BattingStats> updateBattingStats(
            @PathVariable Integer battingStatsId,
            @RequestBody BattingStats battingStats) {
        return ResponseEntity.ok(battingStatsService.updateBattingStats(battingStatsId, battingStats));
    }

    @DeleteMapping("/{battingStatsId}")
    @Operation(summary = "Delete batting statistics")
    public ResponseEntity<Void> deleteBattingStats(@PathVariable Integer battingStatsId) {
        battingStatsService.deleteBattingStats(battingStatsId);
        return ResponseEntity.ok().build();
    }
} 