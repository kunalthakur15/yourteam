package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
} 