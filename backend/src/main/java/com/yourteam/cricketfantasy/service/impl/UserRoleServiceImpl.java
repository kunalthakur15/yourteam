package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.UserRole;
import com.yourteam.cricketfantasy.repository.UserRoleRepository;
import com.yourteam.cricketfantasy.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getUserRoleById(Integer roleId) {
        return userRoleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("User role not found with id: " + roleId));
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole updateUserRole(Integer roleId, UserRole userRole) {
        UserRole existingUserRole = getUserRoleById(roleId);
        existingUserRole.setRoleName(userRole.getRoleName());
        return userRoleRepository.save(existingUserRole);
    }

    @Override
    public void deleteUserRole(Integer roleId) {
        userRoleRepository.deleteById(roleId);
    }
} 