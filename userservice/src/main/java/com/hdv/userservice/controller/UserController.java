package com.hdv.userservice.controller;

import com.hdv.userservice.entity.User;
import com.hdv.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService  userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public User getUser(@RequestBody User user) {
        return userService.create(user);
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
