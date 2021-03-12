package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class ConcertTicket implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public ConcertTicket(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        inventoryItem.increaseQuality();

        if (inventoryItem.sellsIn(10)) {
            inventoryItem.increaseQuality();
        }

        if (inventoryItem.sellsIn(5)) {
            inventoryItem.increaseQuality();
        }

        if (inventoryItem.isExpired()) {
            inventoryItem.dropQuality();
        }
    }

}
