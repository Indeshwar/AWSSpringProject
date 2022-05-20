package com.example.aws.controller;

import com.example.aws.entity.User;
import com.example.aws.service.UserSerivice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserSerivice userSerivice;

    public UserController(UserSerivice userSerivice){
        this.userSerivice = userSerivice;
    }

    //get all user
    @GetMapping
    public List<User> getAllUsers(){
        return userSerivice.getAllUsers();
    }

    //get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable (value = "id") long userId){
        return userSerivice.getUserById(userId);
    }

    //create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userSerivice.createUser(user);
    }

    //update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable (value = "id") long userId){
        return userSerivice.updateUser(user, userId);
    }

    //delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long userId){
        return userSerivice.deleteUser(userId);
    }

}
