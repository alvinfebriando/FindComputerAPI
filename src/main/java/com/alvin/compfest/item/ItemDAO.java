package com.alvin.compfest.item;

import java.util.List;
import java.util.UUID;

public interface ItemDAO {
    Item insertItem(UUID id, Item item);

    default Item insertItem(Item item) {
        UUID id = UUID.randomUUID();
        return insertItem(id, item);
    }

    void removeItem(UUID id);

    void updateItem(UUID id, Item item);

    Item getItem(UUID id);

    List<Item> getItems();

    List<Item> getItems(String username);

    List<Item> getItems(Category category);
}
