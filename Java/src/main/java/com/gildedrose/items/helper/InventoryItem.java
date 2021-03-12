package com.gildedrose.items.helper;

import com.gildedrose.Item;

public class InventoryItem {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

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

    public void increaseQuality(int increment) {
        item.quality = Math.min(MAX_QUALITY, item.quality + increment);
    }

    public void increaseQuality() {
        increaseQuality(1);
    }

    public void decreaseQuality(int decrement) {
        item.quality = Math.max(MIN_QUALITY, item.quality - decrement);
    }

    public void decreaseQuality() {
        decreaseQuality(1);
    }

    public void dropQuality() {
        item.quality = MIN_QUALITY;
    }

    public boolean sellsIn(int numberOfDays) {
        return item.sellIn < numberOfDays;
    }
}
