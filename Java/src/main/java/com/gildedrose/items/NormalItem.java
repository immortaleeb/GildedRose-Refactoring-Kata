package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class NormalItem extends ExpireableItem {

    private static final int QUALITY_EXPIRATION_RATE = 1;

    public NormalItem(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality(2 * QUALITY_EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality(QUALITY_EXPIRATION_RATE);
    }

}
