package com.alvin.compfest.user;

import java.util.UUID;

public interface UserDAO {
    void insertPerson(UUID id, User user);

    default void insertPerson(User user) {
        UUID id = UUID.randomUUID();
        insertPerson(id, user);
    }

    User getUser(UUID id);
}