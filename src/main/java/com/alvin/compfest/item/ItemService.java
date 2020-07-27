package com.alvin.compfest.item;

import java.util.List;
import java.util.UUID;

import com.alvin.compfest.user.User;
import com.alvin.compfest.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemDAO itemDAO;
    private final UserService userService;

    @Autowired
    public ItemService(@Qualifier("arrayListItemDAO") ItemDAO itemDAO, UserService userService) {
        this.itemDAO = itemDAO;
        this.userService = userService;

        User u1 = new User();
        u1.setUsername("john");
        User u2 = new User();
        u2.setUsername("test");

        Item i1 = new Item(UUID.randomUUID(), "AMD Ryzen 5 3600",
                "AMD Ryzen 5 3600 6-Core 3.6 GHz AM4", Category.PROCESSOR, 3_000_000, u1);
        Item i2 = new Item(UUID.randomUUID(), "Intel Core i5 10600K",
                "Processor core i5 10600K 4.1 GHz BOX socket 1200", Category.PROCESSOR, 4_500_000,
                u1);
        Item i3 = new Item(UUID.randomUUID(), "Corsair Vengeance RGB Pro 2x8GB DDR4",
                "CORSAIR - CMW16GX4M2C3200C16 Vengeance RGB Pro 2x8GB DDR4 3200", Category.RAM,
                1_600_000, u1);

        Item i4 = new Item(UUID.randomUUID(), "Samsung SSD 860 EVO", "Samsung SSD SATA 250GB",
                Category.STORAGE, 1_200_000, u2);

        embedUser(i1);
        embedUser(i2);
        embedUser(i3);
        embedUser(i4);

        addItem(i1);
        addItem(i2);
        addItem(i3);
        addItem(i4);

    }

    public Item addItem(Item item) {
        return itemDAO.insertItem(item);
    }

    public void embedUser(Item item) {
        String name = item.getOwner().getUsername();
        User owner = userService.findUser(name);
        item.setOwner(owner);
    }

    public void removeItem(UUID id) {
        itemDAO.removeItem(id);
    }

    public void updateItem(UUID id, Item item) {
        itemDAO.updateItem(id, item);
    }

    public List<Item> getAllItems() {
        return itemDAO.getItems();
    }

    public List<Item> searchItemsByCategory(Category category) {
        return itemDAO.getItems(category);
    }

    public List<Item> searchItemsByOwner(String username) {
        return itemDAO.getItems(username);
    }

    public Item getItem(UUID id) {
        return itemDAO.getItem(id);
    }

    public Item buy(UUID id, String username) {
        Item i = itemDAO.getItem(id);
        User u = userService.findUser(username);
        i.setOwner(u);
        return i;
    }
}
