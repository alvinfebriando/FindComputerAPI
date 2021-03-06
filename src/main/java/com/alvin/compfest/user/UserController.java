package com.alvin.compfest.user;

import com.alvin.compfest.exception.ResourceAlreadyExistsException;
import com.alvin.compfest.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(path = "{username}")
    public User getUser(@PathVariable("username") String username) throws Exception {
        User user = this.userService.findUser(username);
        if (user == null) {
            throw new ResourceNotFoundException("User");
        }
        return user;
    }

    @PutMapping(path = "{username}")
    public User updateUser(@PathVariable("username") String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return userService.findUser(username);
    }
}
