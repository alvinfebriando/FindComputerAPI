package com.alvin.compfest.item;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemDAO itemDAO;

    @Autowired
    public ItemService(@Qualifier("arrayListItemDAO") ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public Item addItem(Item item) {
        return itemDAO.insertItem(item);
    }

    public void removeItem(UUID id) {
        itemDAO.removeItem(id);
    }

    public void updateItem(UUID id, Item item) {
        itemDAO.updateItem(id, item);
    }

    public List<Item> searchItemsByCategory(Category category) {
        return itemDAO.getItems(category);
    }

    public List<Item> searchItemsByOwner(UUID ownerId) {
        return itemDAO.getItems(ownerId);
    }

    public Item getItem(UUID id) {
        return itemDAO.getItem(id);
    }
}