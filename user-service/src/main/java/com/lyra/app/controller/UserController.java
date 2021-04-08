package com.lyra.app.controller;

import com.lyra.app.beans.User;
import com.lyra.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RefreshScope
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @GetMapping("/{name}")
    public User getUserById(@PathVariable("name") String name){
        return userService.getUser(name);
    }

    @PutMapping("/")
    public void createUser(){

    }
}
