package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.Umpire;
import com.yourteam.cricketfantasy.repository.UmpireRepository;
import com.yourteam.cricketfantasy.service.UmpireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UmpireServiceImpl implements UmpireService {

    @Autowired
    private UmpireRepository umpireRepository;

    @Override
    public Umpire createUmpire(Umpire umpire) {
        return umpireRepository.save(umpire);
    }

    @Override
    public Umpire getUmpireById(Integer umpireId) {
        return umpireRepository.findById(umpireId)
                .orElseThrow(() -> new RuntimeException("Umpire not found with id: " + umpireId));
    }

    @Override
    public List<Umpire> getAllUmpires() {
        return umpireRepository.findAll();
    }

    @Override
    public Umpire updateUmpire(Integer umpireId, Umpire umpire) {
        Umpire existingUmpire = getUmpireById(umpireId);
        existingUmpire.setFirstName(umpire.getFirstName());
        existingUmpire.setLastName(umpire.getLastName());
        existingUmpire.setNationality(umpire.getNationality());
        return umpireRepository.save(existingUmpire);
    }

    @Override
    public void deleteUmpire(Integer umpireId) {
        umpireRepository.deleteById(umpireId);
    }
} 