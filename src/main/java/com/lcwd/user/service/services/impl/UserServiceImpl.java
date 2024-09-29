package com.lcwd.user.service.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        User userObj = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given Id is not found ::"+userId));
        Rating[] ratingsArr = restTemplate.getForObject("http://localhost:8083/ratings/by/user?userId="+userId, Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsArr).toList();
        userObj.setRatings(ratings);
        return userObj;
        
    }
}