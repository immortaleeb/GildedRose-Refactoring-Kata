package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class AgeableItem implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public AgeableItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        int qualityUpdateRate = qualityUpdateRate();

        inventoryItem.increaseQuality(qualityUpdateRate);
    }

    private int qualityUpdateRate() {
        return inventoryItem.isExpired() ? 2 : 1;
    }

}
