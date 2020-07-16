package com.alvin.compfest.item;

import java.util.UUID;

public class Item {
    private final UUID id;
    private final String name;
    private final String description;
    private final Category category;
    private final int price;
    private final UUID ownerId;

    public Item(UUID id, String name, String description, Category category, int price, UUID owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.ownerId = owner;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public UUID getOwner() {
        return ownerId;
    }
}