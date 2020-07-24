package com.alvin.compfest.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    public UserService(@Qualifier("arrayListUserDAO") UserDAO userDAO, BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }

    public User createUser(User user) {
        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
        return this.userDAO.insertUser(user);
    }

    public User findUser(UUID id) {
        return this.userDAO.getUser(id);
    }
}