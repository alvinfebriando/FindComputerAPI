package com.alvin.compfest.item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository("arrayListItemDAO")
public class ArrayListItemDAO implements ItemDAO {
    private List<Item> DB = new ArrayList<Item>();

    @Override
    public Item insertItem(UUID id, Item newItem) {
        Item i = new Item(id, newItem.getName(), newItem.getDescription(), newItem.getCategory(), newItem.getPrice(),
                newItem.getOwner());
        DB.add(i);
        return i;
    }

    @Override
    public void removeItem(UUID id) {
        DB.removeIf(item -> id.equals(item.getId()));
    }

    @Override
    public void updateItem(UUID id, Item updatedItem) {
        DB.removeIf(item -> item.getId().equals(id));
        DB.add(updatedItem);
    }

    @Override
    public Item getItem(UUID id) {
        return DB.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);
    }

    @Override
    public List<Item> getItems(UUID owner) {
        return DB.stream().filter(item -> item.getOwner().equals(owner)).collect(Collectors.toList());
    }

    @Override
    public List<Item> getItems(Category category) {
        return DB.stream().filter(item -> item.getCategory().equals(category)).collect(Collectors.toList());
    }

}