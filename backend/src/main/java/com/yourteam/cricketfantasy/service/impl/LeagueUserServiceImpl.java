package com.yourteam.cricketfantasy.service.impl;

import com.yourteam.cricketfantasy.model.User;
import com.yourteam.cricketfantasy.repository.UserRepository;
import com.yourteam.cricketfantasy.service.LeagueUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeagueUserServiceImpl implements LeagueUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createLeagueUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getLeagueUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("League user not found with id: " + id));
    }

    @Override
    public List<User> getAllLeagueUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateLeagueUser(Long id, User user) {
        User existingUser = getLeagueUserById(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(user.getPassword());
        existingUser.setFantasyTeams(user.getFantasyTeams());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteLeagueUser(Long id) {
        userRepository.deleteById(id);
    }
} 