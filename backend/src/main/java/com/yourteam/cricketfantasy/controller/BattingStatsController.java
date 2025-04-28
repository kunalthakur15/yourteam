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