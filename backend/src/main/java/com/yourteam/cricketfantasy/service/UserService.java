package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
} 