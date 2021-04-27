package com.lyra.app.service;

import com.lyra.app.beans.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserByName(String name);

    void newUser(User user);
    void deleteUser(int id);
}
