package com.alvin.compfest.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("arrayListUserDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        this.userDAO.insertPerson(user);
    }

    public User findUser(UUID id) {
        return this.userDAO.getUser(id);
    }
}