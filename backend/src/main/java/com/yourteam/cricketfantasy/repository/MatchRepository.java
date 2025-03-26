package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.Match;
import com.yourteam.cricketfantasy.model.MatchType;
import com.yourteam.cricketfantasy.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByTournamentTournamentId(Integer tournamentId);
    List<Match> findByTeam1OrTeam2(Team team1, Team team2);
    List<Match> findByMatchDateBetween(LocalDate startDate, LocalDate endDate);
    List<Match> findByMatchType(MatchType matchType);
    List<Match> findByWinningTeam(Team winningTeam);
} 