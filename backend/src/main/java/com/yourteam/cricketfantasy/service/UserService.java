package com.yourteam.cricketfantasy.service;

import com.yourteam.cricketfantasy.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    User updateUser(Integer userId, User userDetails);
    void deleteUser(Integer userId);
} 