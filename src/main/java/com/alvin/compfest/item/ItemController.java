package com.alvin.compfest.item;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alvin.compfest.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/items")
@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems(@RequestParam Map<String, String> params) {
        if (params.containsKey("ownerId")) {
            UUID ownerId = UUID.fromString(params.get("ownerId"));
            return itemService.searchItemsByOwner(ownerId);
        } else if (params.containsKey("category")) {
            Category category = Category.valueOf(params.get("category"));
            return itemService.searchItemsByCategory(category);
        } else {
            return null;
        }
    }

    @GetMapping(path = "{id}")
    public Item getItem(@PathVariable("id") UUID id) {
        return itemService.getItem(id);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        itemService.embedUser(item);
        return itemService.addItem(item);
    }

    @PutMapping("{id}")
    public void updateItem(@PathVariable("id") UUID id, @RequestBody Item item) {
        itemService.embedUser(item);
        itemService.updateItem(id, item);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable("id") UUID id) {
        itemService.removeItem(id);
    }
}