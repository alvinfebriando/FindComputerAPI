package com.alvin.compfest.user;

import java.util.UUID;
import com.alvin.compfest.exception.ResourceAlreadyExistsException;
import com.alvin.compfest.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User register(@RequestBody User user) {
        User u = this.userService.findUser(user.getUsername());
        if (u != null) {
            throw new ResourceAlreadyExistsException("User");
        }
        return userService.createUser(user);
    }

    @GetMapping(path = "{id}")
    public User getUser(@PathVariable("id") UUID id) throws Exception {
        User user = this.userService.findUser(id);
        if (user == null) {
            throw new ResourceNotFoundException("User");
        }
        return user;
    }
}
