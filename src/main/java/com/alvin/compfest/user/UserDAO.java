package com.alvin.compfest.user;

import java.util.UUID;

public interface UserDAO {
    void insertUser(UUID id, User user);

    default void insertUser(User user) {
        UUID id = UUID.randomUUID();
        insertUser(id, user);
    }

    User getUser(UUID id);
}