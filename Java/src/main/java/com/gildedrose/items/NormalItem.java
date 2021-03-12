package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class NormalItem implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public NormalItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        if (inventoryItem.isExpired()) {
            inventoryItem.decreaseQuality(2);
        } else {
            inventoryItem.decreaseQuality();
        }
    }

}
