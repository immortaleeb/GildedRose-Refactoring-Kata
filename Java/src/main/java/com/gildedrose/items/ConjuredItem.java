package com.gildedrose.items;

public class ConjuredItem extends ExpireableItem {

    private static final int EXPIRATION_RATE = 2;

    public ConjuredItem(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality(2 * EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality(EXPIRATION_RATE);
    }
}
