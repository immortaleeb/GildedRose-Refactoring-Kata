package com.gildedrose.items;

import com.gildedrose.Item;

public class InventoryItem {
    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public Item item() {
        return item;
    }

}
