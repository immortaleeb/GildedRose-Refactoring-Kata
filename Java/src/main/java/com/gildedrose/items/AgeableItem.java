package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class AgeableItem extends ExpireableItem {

    private static final int QUALITY_EXPIRATION_RATE = 1;

    public AgeableItem(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality(2 * QUALITY_EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality(QUALITY_EXPIRATION_RATE);
    }

}
