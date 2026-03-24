package com.hdv.userservice.controller;

import com.hdv.userservice.entity.User;
import com.hdv.userservice.service.UserService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService  userService;
    @Value("${server.port}")
    private String port;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public User getUser(@RequestBody User user) {
        return userService.create(user);
    }
    @GetMapping("/getAllUser")
    public Map<String, Object> getAllUser() {
        System.out.println("Handled by user service instance port: "+port);
        Map<String, Object> response = new HashMap<>();

        response.put("port", port);
        response.put("user", userService.getAllUser());

        return response;
    }
    
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Handled by UserService instance port: " + port;
    }
}
