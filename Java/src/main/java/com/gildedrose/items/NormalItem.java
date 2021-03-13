package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class NormalItem extends ExpireableItem {

    public NormalItem(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality(2);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality();
    }

}
