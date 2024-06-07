package com.example.demo.menu.menuitem;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tt_staff_member")
public class MenuItem extends AbstractEntity<MenuItemId> {

    @NotNull
    private MenuItemName itemName;
    @NotNull
    private double price;

    /**
     * Default constructor for JPA
     */
    protected MenuItem() {
    }

    public MenuItem(MenuItemId id, MenuItemName itemName, double price) {
        super(id);
        this.itemName = itemName;
        this.price = price;
    }

    public @NotNull MenuItemName getItemName() {
        return itemName;
    }

    @NotNull
    public double getPrice() {
        return price;
    }
}