package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class ConcertTicket extends ExpireableItem {

    public ConcertTicket(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        inventoryItem.dropQuality();
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality();

        if (inventoryItem.sellsIn(10)) {
            inventoryItem.increaseQuality();
        }

        if (inventoryItem.sellsIn(5)) {
            inventoryItem.increaseQuality();
        }
    }

}
