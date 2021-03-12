package com.gildedrose.items.helper;

import com.gildedrose.Item;

public class InventoryItem {
    private final Item item;
    private final ItemType type;

    public InventoryItem(Item item, ItemType type) {
        this.item = item;
        this.type = type;
    }

    public ItemType type() {
        return type;
    }

    public void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    public boolean isExpired() {
        return item.sellIn < 0;
    }

    public void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public void dropQuality() {
        item.quality = 0;
    }

    public boolean sellsIn(int numberOfDays) {
        return item.sellIn < numberOfDays;
    }
    
}
