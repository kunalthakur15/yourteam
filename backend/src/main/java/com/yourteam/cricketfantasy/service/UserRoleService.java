package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.UserRole;
import java.util.List;

public interface UserRoleService {
    UserRole createUserRole(UserRole userRole);
    UserRole getUserRoleById(Integer roleId);
    List<UserRole> getAllUserRoles();
    UserRole updateUserRole(Integer roleId, UserRole userRole);
    void deleteUserRole(Integer roleId);
} 