package com.example.demo.menu.menuitem;


import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

@Embeddable
public class MenuItemName {
    private String itemName;
    private String description;

    protected MenuItemName() {
    }

    public MenuItemName(String itemName, String description) {
        Assert.hasText(itemName, "itemName cannot be blank");
        Assert.hasText(description, "description cannot be blank");
        this.itemName = itemName;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        com.example.demo.menu.menuitem.MenuItemName menuItemName = (com.example.demo.menu.menuitem.MenuItemName) o;
        return Objects.equals(itemName, menuItemName.itemName) &&
                Objects.equals(description, menuItemName.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, description);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("itemName", itemName)
                .add("description", description)
                .toString();
    }
}