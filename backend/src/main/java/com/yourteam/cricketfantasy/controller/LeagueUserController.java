package com.yourteam.cricketfantasy.controller;

import com.yourteam.cricketfantasy.model.User;
import com.yourteam.cricketfantasy.service.LeagueUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/league-users")
@Tag(name = "League User Management", description = "APIs for managing league users")
public class LeagueUserController {

    @Autowired
    private LeagueUserService leagueUserService;

    @PostMapping
    @Operation(summary = "Create a new league user")
    public ResponseEntity<User> createLeagueUser(@RequestBody User user) {
        return ResponseEntity.ok(leagueUserService.createLeagueUser(user));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a league user by ID")
    public ResponseEntity<User> getLeagueUserById(@PathVariable Long id) {
        return ResponseEntity.ok(leagueUserService.getLeagueUserById(id));
    }

    @GetMapping
    @Operation(summary = "Get all league users")
    public ResponseEntity<List<User>> getAllLeagueUsers() {
        return ResponseEntity.ok(leagueUserService.getAllLeagueUsers());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a league user")
    public ResponseEntity<User> updateLeagueUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(leagueUserService.updateLeagueUser(id, user));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a league user")
    public ResponseEntity<Void> deleteLeagueUser(@PathVariable Long id) {
        leagueUserService.deleteLeagueUser(id);
        return ResponseEntity.ok().build();
    }
} 