package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class AgeableItem extends ExpireableItem {

    public AgeableItem(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality(2);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality();
    }

}
