package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.FantasyTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FantasyTeamRepository extends JpaRepository<FantasyTeam, Integer> {
    List<FantasyTeam> findByUserId(Long userId);
} 