package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.FallOfWickets;
import java.util.List;

public interface FallOfWicketsService {
    FallOfWickets createFallOfWickets(FallOfWickets fallOfWickets);
    FallOfWickets getFallOfWicketsById(Integer id);
    List<FallOfWickets> getAllFallOfWickets();
    List<FallOfWickets> getFallOfWicketsByMatch(Integer matchId);
    List<FallOfWickets> getFallOfWicketsByMatchAndInnings(Integer matchId, Integer innings);
    List<FallOfWickets> getFallOfWicketsByTeam(Integer teamId);
    FallOfWickets updateFallOfWickets(Integer id, FallOfWickets fallOfWickets);
    void deleteFallOfWickets(Integer id);
} 