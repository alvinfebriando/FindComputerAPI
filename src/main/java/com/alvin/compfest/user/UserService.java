package com.alvin.compfest.user;

import static java.util.Collections.emptyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserDAO userDAO;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    public UserService(@Qualifier("arrayListUserDAO") UserDAO userDAO,
            BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;

        createUser(new User("Test", "test", "test123", "test@gmail.com"));
        createUser(new User("John Doe", "john", "john123", "john@gmail.com"));
    }

    public User createUser(User user) {
        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
        return this.userDAO.insertUser(user);
    }

    public User findUser(String username) {
        return this.userDAO.getUser(username);
    }

    public void updateUser(String username, User user) {
        userDAO.deleteUser(username);
        createUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userDAO.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), emptyList());
    }

}
