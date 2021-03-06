package com.alvin.compfest.item;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alvin.compfest.exception.ResourceNotFoundException;
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
        if (params.containsKey("username")) {
            String username = params.get("username");
            return itemService.searchItemsByOwner(username);
        } else if (params.containsKey("category")) {
            Category category = Category.valueOf(params.get("category"));
            return itemService.searchItemsByCategory(category);
        } else {
            return itemService.getAllItems();
        }
    }

    @GetMapping(path = "{id}")
    public Item getItem(@PathVariable("id") UUID id) {
        Item item = itemService.getItem(id);
        if (item == null) {
            throw new ResourceNotFoundException("item");
        }
        return item;
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        itemService.embedUser(item);
        return itemService.addItem(item);
    }

    @PutMapping("{id}")
    public Item updateItem(@PathVariable("id") UUID id, @RequestBody Item item) {
        itemService.embedUser(item);
        itemService.updateItem(id, item);
        return itemService.getItem(id);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable("id") UUID id) {
        itemService.removeItem(id);
    }

    @PostMapping("{id}/{username}")
    public Item buyItem(@PathVariable("id") UUID id, @PathVariable("username") String username) {
        return itemService.buy(id, username);
    }
}
