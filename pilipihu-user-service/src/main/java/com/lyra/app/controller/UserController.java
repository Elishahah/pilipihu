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
        String defaultBehav = "redirect:login";

        if(cookies == null){
            return defaultBehav;
        }

        HttpSession session = request.getSession(false);
        String sessionId = session.getId();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("JSESSIONID") && cookie.getValue().equals(sessionId)){
                for(Cookie c1: cookies){
                    if(c1.getName().equals("userName")){
                        String name = c1.getValue();
                        try {
                            String realPass = userService.getUserByName(name).getUserPassword();
                            if(session.getAttribute("password").equals(realPass)){
                                return "welcome";
                            }
                        }catch(NullPointerException e){
                            return defaultBehav;
                        }
                    }
                }
            }else{
                return defaultBehav;
            }
        }
        return defaultBehav;
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
