package com.yourteam.cricketfantasy.repository;

import com.yourteam.cricketfantasy.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
} 