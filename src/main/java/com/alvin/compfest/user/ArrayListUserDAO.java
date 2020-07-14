package com.alvin.compfest.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository("arrayListUserDAO")
public class ArrayListUserDAO implements UserDAO {
    private static List<User> DB = new ArrayList<User>();

    @Override
    public void insertPerson(UUID id, User user) {
        DB.add(new User(id, user.getName(), user.getUsername(), user.getPassword(), user.getEmail()));
    }

    @Override
    public User getUser(UUID id) {
        return DB.stream().filter(user -> id.equals(user.getId())).findAny().orElse(null);
    }
}