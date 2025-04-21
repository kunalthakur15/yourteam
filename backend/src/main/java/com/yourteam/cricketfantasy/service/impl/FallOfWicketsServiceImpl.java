package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.FallOfWickets;
import com.yourteam.cricketfantasy.repository.FallOfWicketsRepository;
import com.yourteam.cricketfantasy.service.FallOfWicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FallOfWicketsServiceImpl implements FallOfWicketsService {

    @Autowired
    private FallOfWicketsRepository fallOfWicketsRepository;

    @Override
    public FallOfWickets createFallOfWickets(FallOfWickets fallOfWickets) {
        return fallOfWicketsRepository.save(fallOfWickets);
    }

    @Override
    public FallOfWickets getFallOfWicketsById(Integer id) {
        return fallOfWicketsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fall of wickets not found with id: " + id));
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
    public List<FallOfWickets> getFallOfWicketsByMatchAndInnings(Integer matchId, Integer innings) {
        return fallOfWicketsRepository.findByMatchMatchIdAndInnings(matchId, innings);
    }

    @Override
    public List<FallOfWickets> getFallOfWicketsByTeam(Integer teamId) {
        return fallOfWicketsRepository.findByTeamTeamId(teamId);
    }

    @Override
    public FallOfWickets updateFallOfWickets(Integer id, FallOfWickets fallOfWickets) {
        FallOfWickets existingFallOfWickets = getFallOfWicketsById(id);
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
    public void deleteFallOfWickets(Integer id) {
        fallOfWicketsRepository.deleteById(id);
    }
} 