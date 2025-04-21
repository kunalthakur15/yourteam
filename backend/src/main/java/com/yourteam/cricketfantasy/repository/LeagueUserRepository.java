package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.LeagueUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueUserRepository extends JpaRepository<LeagueUser, Long> {
} 