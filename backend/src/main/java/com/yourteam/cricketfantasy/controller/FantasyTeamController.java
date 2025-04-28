package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.FantasyTeam;
import com.yourteam.cricketfantasy.service.FantasyTeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fantasy-teams")
@Tag(name = "Fantasy Team Management", description = "APIs for managing fantasy teams")
public class FantasyTeamController {

    @Autowired
    private FantasyTeamService fantasyTeamService;

    @PostMapping
    @Operation(summary = "Create a new fantasy team")
    public ResponseEntity<FantasyTeam> createFantasyTeam(@RequestBody FantasyTeam fantasyTeam) {
        return ResponseEntity.ok(fantasyTeamService.createFantasyTeam(fantasyTeam));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a fantasy team by ID")
    public ResponseEntity<FantasyTeam> getFantasyTeamById(@PathVariable Integer id) {
        return ResponseEntity.ok(fantasyTeamService.getFantasyTeamById(id));
    }

    @GetMapping
    @Operation(summary = "Get all fantasy teams")
    public ResponseEntity<List<FantasyTeam>> getAllFantasyTeams() {
        return ResponseEntity.ok(fantasyTeamService.getAllFantasyTeams());
    }

    @GetMapping("/league-user/{leagueUserId}")
    @Operation(summary = "Get fantasy teams by league user ID")
    public ResponseEntity<List<FantasyTeam>> getFantasyTeamsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(fantasyTeamService.getFantasyTeamsByUser(userId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a fantasy team")
    public ResponseEntity<FantasyTeam> updateFantasyTeam(@PathVariable Integer id, @RequestBody FantasyTeam fantasyTeam) {
        return ResponseEntity.ok(fantasyTeamService.updateFantasyTeam(id, fantasyTeam));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a fantasy team")
    public ResponseEntity<Void> deleteFantasyTeam(@PathVariable Integer id) {
        fantasyTeamService.deleteFantasyTeam(id);
        return ResponseEntity.ok().build();
    }
} 