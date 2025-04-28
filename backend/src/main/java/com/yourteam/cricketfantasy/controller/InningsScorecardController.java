package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.InningsScorecard;
import com.yourteam.cricketfantasy.service.InningsScorecardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/innings-scorecards")
@Tag(name = "Innings Scorecard Management", description = "APIs for managing innings scorecards")
public class InningsScorecardController {

    @Autowired
    private InningsScorecardService inningsScorecardService;

    @PostMapping
    @Operation(summary = "Create a new innings scorecard")
    public ResponseEntity<InningsScorecard> createInningsScorecard(@RequestBody InningsScorecard inningsScorecard) {
        return ResponseEntity.ok(inningsScorecardService.createInningsScorecard(inningsScorecard));
    }

    @GetMapping("/{inningsScorecardId}")
    @Operation(summary = "Get an innings scorecard by ID")
    public ResponseEntity<InningsScorecard> getInningsScorecardById(@PathVariable Integer inningsScorecardId) {
        return ResponseEntity.ok(inningsScorecardService.getInningsScorecardById(inningsScorecardId));
    }

    @GetMapping
    @Operation(summary = "Get all innings scorecards")
    public ResponseEntity<List<InningsScorecard>> getAllInningsScorecards() {
        return ResponseEntity.ok(inningsScorecardService.getAllInningsScorecards());
    }

    @GetMapping("/match/{matchId}")
    @Operation(summary = "Get innings scorecards by match ID")
    public ResponseEntity<List<InningsScorecard>> getInningsScorecardsByMatch(@PathVariable Integer matchId) {
        return ResponseEntity.ok(inningsScorecardService.getInningsScorecardsByMatch(matchId));
    }

    @GetMapping("/match/{matchId}/innings/{innings}")
    @Operation(summary = "Get innings scorecard by match ID and innings")
    public ResponseEntity<InningsScorecard> getInningsScorecardByMatchAndInnings(
            @PathVariable Integer matchId,
            @PathVariable Integer innings) {
        return ResponseEntity.ok(inningsScorecardService.getInningsScorecardByMatchAndInnings(matchId, innings));
    }

    @PutMapping("/{inningsScorecardId}")
    @Operation(summary = "Update an innings scorecard")
    public ResponseEntity<InningsScorecard> updateInningsScorecard(
            @PathVariable Integer inningsScorecardId,
            @RequestBody InningsScorecard inningsScorecard) {
        return ResponseEntity.ok(inningsScorecardService.updateInningsScorecard(inningsScorecardId, inningsScorecard));
    }

    @DeleteMapping("/{inningsScorecardId}")
    @Operation(summary = "Delete an innings scorecard")
    public ResponseEntity<Void> deleteInningsScorecard(@PathVariable Integer inningsScorecardId) {
        inningsScorecardService.deleteInningsScorecard(inningsScorecardId);
        return ResponseEntity.ok().build();
    }
} 