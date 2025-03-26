package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.FallOfWickets;
import com.yourteam.cricketfantasy.model.Team;
import com.yourteam.cricketfantasy.repository.FallOfWicketsRepository;
import com.yourteam.cricketfantasy.service.FallOfWicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FallOfWicketsServiceImpl implements FallOfWicketsService {

    @Autowired
    private FallOfWicketsRepository fallOfWicketsRepository;

    @Override
    @Transactional
    public FallOfWickets createFallOfWickets(FallOfWickets fallOfWickets) {
        return fallOfWicketsRepository.save(fallOfWickets);
    }

    @Override
    public FallOfWickets getFallOfWicketsById(Integer fallOfWicketId) {
        return fallOfWicketsRepository.findById(fallOfWicketId)
                .orElseThrow(() -> new RuntimeException("Fall of Wickets not found with id: " + fallOfWicketId));
    }

    @Override
    public List<FallOfWickets> getAllFallOfWickets() {
        return fallOfWicketsRepository.findAll();
    }

    @Override
    public List<FallOfWickets> getFallOfWicketsByMatch(Integer matchId) {
        return fallOfWicketsRepository.findByMatchMatchId(matchId);
    }

    @Override
    public List<FallOfWickets> getFallOfWicketsByTeam(Team team) {
        return fallOfWicketsRepository.findByTeam(team);
    }

    @Override
    public List<FallOfWickets> getFallOfWicketsByMatchAndTeam(Integer matchId, Integer teamId) {
        return fallOfWicketsRepository.findByMatchMatchIdAndTeamTeamId(matchId, teamId);
    }

    @Override
    public List<FallOfWickets> getFallOfWicketsByMatchAndInnings(Integer matchId, Integer innings) {
        return fallOfWicketsRepository.findByMatchMatchIdAndInnings(matchId, innings);
    }

    @Override
    @Transactional
    public FallOfWickets updateFallOfWickets(Integer fallOfWicketId, FallOfWickets fallOfWickets) {
        FallOfWickets existingFallOfWickets = getFallOfWicketsById(fallOfWicketId);
        // Update fields
        existingFallOfWickets.setMatch(fallOfWickets.getMatch());
        existingFallOfWickets.setTeam(fallOfWickets.getTeam());
        existingFallOfWickets.setInnings(fallOfWickets.getInnings());
        existingFallOfWickets.setWicketNumber(fallOfWickets.getWicketNumber());
        existingFallOfWickets.setRunsAtWicket(fallOfWickets.getRunsAtWicket());
        existingFallOfWickets.setOversAtWicket(fallOfWickets.getOversAtWicket());
        existingFallOfWickets.setBatsmanOut(fallOfWickets.getBatsmanOut());
        existingFallOfWickets.setBowler(fallOfWickets.getBowler());
        existingFallOfWickets.setPartner1(fallOfWickets.getPartner1());
        existingFallOfWickets.setPartner2(fallOfWickets.getPartner2());
        return fallOfWicketsRepository.save(existingFallOfWickets);
    }

    @Override
    @Transactional
    public void deleteFallOfWickets(Integer fallOfWicketId) {
        fallOfWicketsRepository.deleteById(fallOfWicketId);
    }
} 