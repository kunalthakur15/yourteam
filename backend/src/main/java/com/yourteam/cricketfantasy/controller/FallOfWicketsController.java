package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.FallOfWickets;
import com.yourteam.cricketfantasy.service.FallOfWicketsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fall-of-wickets")
@Tag(name = "Fall of Wickets Management", description = "APIs for managing fall of wickets data")
public class FallOfWicketsController {

    @Autowired
    private FallOfWicketsService fallOfWicketsService;

    @PostMapping
    @Operation(summary = "Create new fall of wickets record")
    public ResponseEntity<FallOfWickets> createFallOfWickets(@RequestBody FallOfWickets fallOfWickets) {
        return ResponseEntity.ok(fallOfWicketsService.createFallOfWickets(fallOfWickets));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get fall of wickets by ID")
    public ResponseEntity<FallOfWickets> getFallOfWicketsById(@PathVariable Integer id) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsById(id));
    }

    @GetMapping
    @Operation(summary = "Get all fall of wickets records")
    public ResponseEntity<List<FallOfWickets>> getAllFallOfWickets() {
        return ResponseEntity.ok(fallOfWicketsService.getAllFallOfWickets());
    }

    @GetMapping("/match/{matchId}")
    @Operation(summary = "Get fall of wickets by match ID")
    public ResponseEntity<List<FallOfWickets>> getFallOfWicketsByMatch(@PathVariable Integer matchId) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsByMatch(matchId));
    }

    @GetMapping("/match/{matchId}/innings/{innings}")
    @Operation(summary = "Get fall of wickets by match ID and innings")
    public ResponseEntity<List<FallOfWickets>> getFallOfWicketsByMatchAndInnings(
            @PathVariable Integer matchId,
            @PathVariable Integer innings) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsByMatchAndInnings(matchId, innings));
    }

    @GetMapping("/team/{teamId}")
    @Operation(summary = "Get fall of wickets by team ID")
    public ResponseEntity<List<FallOfWickets>> getFallOfWicketsByTeam(@PathVariable Integer teamId) {
        return ResponseEntity.ok(fallOfWicketsService.getFallOfWicketsByTeam(teamId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update fall of wickets record")
    public ResponseEntity<FallOfWickets> updateFallOfWickets(
            @PathVariable Integer id,
            @RequestBody FallOfWickets fallOfWickets) {
        return ResponseEntity.ok(fallOfWicketsService.updateFallOfWickets(id, fallOfWickets));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete fall of wickets record")
    public ResponseEntity<Void> deleteFallOfWickets(@PathVariable Integer id) {
        fallOfWicketsService.deleteFallOfWickets(id);
        return ResponseEntity.ok().build();
    }
} 