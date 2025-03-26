package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.FallOfWickets;
import com.yourteam.cricketfantasy.model.Team;
import java.util.List;

public interface FallOfWicketsService {
    FallOfWickets createFallOfWickets(FallOfWickets fallOfWickets);
    FallOfWickets getFallOfWicketsById(Integer fallOfWicketId);
    List<FallOfWickets> getAllFallOfWickets();
    List<FallOfWickets> getFallOfWicketsByMatch(Integer matchId);
    List<FallOfWickets> getFallOfWicketsByTeam(Team team);
    List<FallOfWickets> getFallOfWicketsByMatchAndTeam(Integer matchId, Integer teamId);
    List<FallOfWickets> getFallOfWicketsByMatchAndInnings(Integer matchId, Integer innings);
    FallOfWickets updateFallOfWickets(Integer fallOfWicketId, FallOfWickets fallOfWickets);
    void deleteFallOfWickets(Integer fallOfWicketId);
} 