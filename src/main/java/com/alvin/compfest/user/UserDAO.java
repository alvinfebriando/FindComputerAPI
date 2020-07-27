package com.alvin.compfest.user;

public interface UserDAO {
    User insertUser(User user);

    User getUser(String username);

    void deleteUser(String username);
}
