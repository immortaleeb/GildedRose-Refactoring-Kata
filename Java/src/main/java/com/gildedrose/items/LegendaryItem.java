package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class LegendaryItem implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public LegendaryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public boolean isExpired() {
        return inventoryItem.isExpired();
    }

    @Override
    public void updateSellIn() {
        // nothing to do
    }

    @Override
    public void updateQuality() {
        inventoryItem.increaseQuality();
    }

    @Override
    public void updateExpiredItem() {
        // nothing to do
    }
}
