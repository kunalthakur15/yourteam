package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.PlayerRole;
import com.yourteam.cricketfantasy.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@Tag(name = "Player Management", description = "APIs for managing cricket players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    @Operation(summary = "Create a new player")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.createPlayer(player));
    }

    @GetMapping("/{playerId}")
    @Operation(summary = "Get a player by ID")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer playerId) {
        return ResponseEntity.ok(playerService.getPlayerById(playerId));
    }

    @GetMapping
    @Operation(summary = "Get all players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/team/{teamId}")
    @Operation(summary = "Get players by team ID")
    public ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable Integer teamId) {
        return ResponseEntity.ok(playerService.getPlayersByTeam(teamId));
    }

    @GetMapping("/role/{role}")
    @Operation(summary = "Get players by role")
    public ResponseEntity<List<Player>> getPlayersByRole(@PathVariable String role) {
        return ResponseEntity.ok(playerService.getPlayersByRole(PlayerRole.valueOf(role.toUpperCase())));
    }

    @GetMapping("/team/{teamId}/role/{role}")
    @Operation(summary = "Get players by team ID and role")
    public ResponseEntity<List<Player>> getPlayersByTeamAndRole(
            @PathVariable Integer teamId,
            @PathVariable String role) {
        return ResponseEntity.ok(playerService.getPlayersByTeamAndRole(teamId, PlayerRole.valueOf(role.toUpperCase())));
    }

    @PutMapping("/{playerId}")
    @Operation(summary = "Update a player")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer playerId, @RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(playerId, player));
    }

    @DeleteMapping("/{playerId}")
    @Operation(summary = "Delete a player")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.ok().build();
    }
} 