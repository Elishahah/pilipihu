package com.lyra.app.controller;

import com.lyra.app.beans.User;
import com.lyra.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
@RefreshScope
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/user/{name}")
    public User getUser(@PathVariable("name") String name){
        return userService.getUserByName(name);
    }

    @PostMapping("/user")
    public String login(User user, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();

        if(cookies == null){
            return "redirect:login";
        }

        HttpSession session = request.getSession(false);

        User userInfo = userService.getUserByName(user.getUserName());
        if (user.getUserName().equals(userInfo.getUserName())){
            response.addCookie("","sad");
            return "success";
        }else{
            return "failed";
        }

    }

    @PutMapping("/user")
    public void createUser(User user){
        userService.newUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
}
