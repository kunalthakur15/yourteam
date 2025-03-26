package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.Player;
import com.yourteam.cricketfantasy.model.PlayerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByTeamTeamId(Integer teamId);
    List<Player> findByRole(PlayerRole role);
    List<Player> findByTeamTeamIdAndRole(Integer teamId, PlayerRole role);
} 