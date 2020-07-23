package com.alvin.compfest.user;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final String password;
    private final String email;

    public User(UUID id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}