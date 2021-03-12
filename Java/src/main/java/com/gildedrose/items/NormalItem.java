package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class NormalItem implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public NormalItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public boolean isExpired() {
        return inventoryItem.isExpired();
    }

    @Override
    public void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        inventoryItem.decreaseQuality();

        if (inventoryItem.isExpired()) {
            inventoryItem.decreaseQuality();
        }
    }

    @Override
    public void updateExpiredItem() {

    }
}
