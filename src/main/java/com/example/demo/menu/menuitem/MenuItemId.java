package com.example.demo.menu.menuitem;


import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;
public class MenuItemId extends AbstractEntityId<UUID> {
    /**
     * Default constructor for JPA
     */
    protected MenuItemId() {
    }
    public MenuItemId(UUID id) {
        super(id);
    }
}