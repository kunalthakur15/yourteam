package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.BowlingStats;
import com.yourteam.cricketfantasy.service.BowlingStatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bowling-stats")
@Tag(name = "Bowling Statistics Management", description = "APIs for managing bowling statistics")
public class BowlingStatsController {

    @Autowired
    private BowlingStatsService bowlingStatsService;

    @PostMapping
    @Operation(summary = "Create new bowling statistics")
    public ResponseEntity<BowlingStats> createBowlingStats(@RequestBody BowlingStats bowlingStats) {
        return ResponseEntity.ok(bowlingStatsService.createBowlingStats(bowlingStats));
    }

    @GetMapping("/{bowlingStatsId}")
    @Operation(summary = "Get bowling statistics by ID")
    public ResponseEntity<BowlingStats> getBowlingStatsById(@PathVariable Integer bowlingStatsId) {
        return ResponseEntity.ok(bowlingStatsService.getBowlingStatsById(bowlingStatsId));
    }

    @GetMapping
    @Operation(summary = "Get all bowling statistics")
    public ResponseEntity<List<BowlingStats>> getAllBowlingStats() {
        return ResponseEntity.ok(bowlingStatsService.getAllBowlingStats());
    }

    @PutMapping("/{bowlingStatsId}")
    @Operation(summary = "Update bowling statistics")
    public ResponseEntity<BowlingStats> updateBowlingStats(
            @PathVariable Integer bowlingStatsId,
            @RequestBody BowlingStats bowlingStats) {
        return ResponseEntity.ok(bowlingStatsService.updateBowlingStats(bowlingStatsId, bowlingStats));
    }

    @DeleteMapping("/{bowlingStatsId}")
    @Operation(summary = "Delete bowling statistics")
    public ResponseEntity<Void> deleteBowlingStats(@PathVariable Integer bowlingStatsId) {
        bowlingStatsService.deleteBowlingStats(bowlingStatsId);
        return ResponseEntity.ok().build();
    }
} 