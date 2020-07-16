package com.alvin.compfest.user;

import java.util.UUID;

public interface UserDAO {
    User insertUser(UUID id, User user);

    default User insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    User getUser(UUID id);
}