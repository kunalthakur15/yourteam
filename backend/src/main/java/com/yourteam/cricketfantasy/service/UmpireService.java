package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.Umpire;
import java.util.List;

public interface UmpireService {
    Umpire createUmpire(Umpire umpire);
    Umpire getUmpireById(Integer umpireId);
    List<Umpire> getAllUmpires();
    Umpire updateUmpire(Integer umpireId, Umpire umpire);
    void deleteUmpire(Integer umpireId);
} 