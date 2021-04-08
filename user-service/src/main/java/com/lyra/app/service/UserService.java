package com.lyra.app.service;

import com.lyra.app.beans.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUser(int id);
    User getUser(String name);

    void newUser(User user);
}
