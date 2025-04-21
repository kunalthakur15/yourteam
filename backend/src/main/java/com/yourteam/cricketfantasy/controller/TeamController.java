package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@Tag(name = "Team Management", description = "APIs for managing cricket teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    @Operation(summary = "Create a new team")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    @GetMapping("/{teamId}")
    @Operation(summary = "Get a team by ID")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer teamId) {
        return ResponseEntity.ok(teamService.getTeamById(teamId));
    }

    @GetMapping
    @Operation(summary = "Get all teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @PutMapping("/{teamId}")
    @Operation(summary = "Update a team")
    public ResponseEntity<Team> updateTeam(@PathVariable Integer teamId, @RequestBody Team team) {
        return ResponseEntity.ok(teamService.updateTeam(teamId, team));
    }

    @DeleteMapping("/{teamId}")
    @Operation(summary = "Delete a team")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer teamId) {
        teamService.deleteTeam(teamId);
        return ResponseEntity.ok().build();
    }
} 