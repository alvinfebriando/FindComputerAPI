package com.alvin.compfest.user;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("arrayListUserDAO")
public class ArrayListUserDAO implements UserDAO {
    private static List<User> DB = new ArrayList<User>();


    @Override
    public User insertUser(User user) {
        User u = new User(user.getName(), user.getUsername(), user.getPassword(), user.getEmail());
        DB.add(u);
        return u;
    }

    @Override
    public User getUser(String username) {
        return DB.stream().filter(user -> username.equals(user.getUsername())).findAny()
                .orElse(null);
    }

    @Override
    public void deleteUser(String username) {
        DB.removeIf(u -> u.getUsername().equals((username)));
    }
}
