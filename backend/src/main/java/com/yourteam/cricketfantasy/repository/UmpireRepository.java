package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.Umpire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmpireRepository extends JpaRepository<Umpire, Integer> {
} 