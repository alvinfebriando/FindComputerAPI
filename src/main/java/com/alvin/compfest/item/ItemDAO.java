package com.alvin.compfest.item;

import java.util.List;
import java.util.UUID;

public interface ItemDAO {
    void insertItem(UUID id, Item item);

    default void insertItem(Item item) {
        UUID id = UUID.randomUUID();
        insertItem(id, item);
    }

    void removeItem(UUID id);

    void updateItem(UUID id, Item item);

    Item getItem(UUID id);

    List<Item> getItems(UUID ownerId);

    List<Item> getItems(Category category);
}