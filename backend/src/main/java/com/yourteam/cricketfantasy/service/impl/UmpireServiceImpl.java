package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Umpire;
import com.yourteam.cricketfantasy.repository.UmpireRepository;
import com.yourteam.cricketfantasy.service.UmpireService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UmpireServiceImpl implements UmpireService {

    private final UmpireRepository umpireRepository;

    @Override
    @Transactional
    public Umpire createUmpire(Umpire umpire) {
        return umpireRepository.save(umpire);
    }

    @Override
    public Umpire getUmpireById(Integer umpireId) {
        return umpireRepository.findById(umpireId)
                .orElseThrow(() -> new EntityNotFoundException("Umpire not found with id: " + umpireId));
    }

    @Override
    public List<Umpire> getAllUmpires() {
        return umpireRepository.findAll();
    }

    @Override
    @Transactional
    public Umpire updateUmpire(Integer umpireId, Umpire umpireDetails) {
        Umpire umpire = getUmpireById(umpireId);
        umpire.setFirstName(umpireDetails.getFirstName());
        umpire.setLastName(umpireDetails.getLastName());
        umpire.setNationality(umpireDetails.getNationality());
        return umpireRepository.save(umpire);
    }

    @Override
    @Transactional
    public void deleteUmpire(Integer umpireId) {
        Umpire umpire = getUmpireById(umpireId);
        umpireRepository.delete(umpire);
    }
} 