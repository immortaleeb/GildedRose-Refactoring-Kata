package com.gildedrose.items;

import com.gildedrose.Item;

public class InventoryItem {
    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    public boolean isExpired() {
        return item.sellIn < 0;
    }

    public Item item() {
        return item;
    }

    public boolean sellsIn(int numberOfDays) {
        return item.sellIn < numberOfDays;
    }
}
