package com.example.aws.service;

import com.example.aws.entity.User;
import com.example.aws.exception.ResourceNotFoundException;
import com.example.aws.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerivice {
    private UserRepository userRepository;

    public UserSerivice(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //get all user
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //get user by id
    public User getUserById(Long userId){
        return userRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + userId));
    }

    //create user
    public User createUser(User user){
        return userRepository.save(user);
    }

    //update user
    public User updateUser(User user, Long userId){
        User existingUser = getUserById(userId);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    //delete user
    public ResponseEntity<User> deleteUser(Long userId){
        User user = getUserById(userId);
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
