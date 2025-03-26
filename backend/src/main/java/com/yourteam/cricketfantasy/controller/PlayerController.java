package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.PlayerRole;
import com.yourteam.cricketfantasy.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
@Tag(name = "Player Management", description = "APIs for managing cricket players")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    @Operation(summary = "Create a new player")
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.CREATED);
    }

    @GetMapping("/{playerId}")
    @Operation(summary = "Get player by ID")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer playerId) {
        return ResponseEntity.ok(playerService.getPlayerById(playerId));
    }

    @GetMapping
    @Operation(summary = "Get all players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/team/{teamId}")
    @Operation(summary = "Get players by team")
    public ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable Integer teamId) {
        return ResponseEntity.ok(playerService.getPlayersByTeam(teamId));
    }

    @GetMapping("/role/{role}")
    @Operation(summary = "Get players by role")
    public ResponseEntity<List<Player>> getPlayersByRole(@PathVariable PlayerRole role) {
        return ResponseEntity.ok(playerService.getPlayersByRole(role));
    }

    @GetMapping("/team/{teamId}/role/{role}")
    @Operation(summary = "Get players by team and role")
    public ResponseEntity<List<Player>> getPlayersByTeamAndRole(
            @PathVariable Integer teamId,
            @PathVariable PlayerRole role) {
        return ResponseEntity.ok(playerService.getPlayersByTeamAndRole(teamId, role));
    }

    @PutMapping("/{playerId}")
    @Operation(summary = "Update player")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer playerId, @Valid @RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(playerId, player));
    }

    @DeleteMapping("/{playerId}")
    @Operation(summary = "Delete player")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }
} 