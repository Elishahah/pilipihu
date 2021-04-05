package com.lyra.app.controller;

import com.lyra.app.beans.User;
import com.lyra.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Map<String, List<User> > getAllUsers(){
        List<User> users =  userService.getAllUser();
        Map<String, List<User>> result = new HashMap<>();
        result.put("users",users);
        return result;
    }
}
