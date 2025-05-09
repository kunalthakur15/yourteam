package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
} 