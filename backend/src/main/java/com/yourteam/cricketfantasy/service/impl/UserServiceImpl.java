package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.User;
import com.yourteam.cricketfantasy.repository.UserRepository;
import com.yourteam.cricketfantasy.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUser(Integer userId, User userDetails) {
        User user = getUserById(userId);
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setUserRole(userDetails.getUserRole());
        user.setFantasyLeagueId(userDetails.getFantasyLeagueId());
        user.setFantasyTeamId(userDetails.getFantasyTeamId());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }
} 