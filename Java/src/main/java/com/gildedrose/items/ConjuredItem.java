package com.gildedrose.items;

public class ConjuredItem extends ExpireableItem {

    private static final int EXPIRATION_RATE = 2;

    private final Quality quality;

    public ConjuredItem(InventoryItem inventoryItem) {
        super(inventoryItem);
        quality = new Quality(inventoryItem.item());
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        quality.decrease(2 * EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        quality.decrease(EXPIRATION_RATE);
    }
}
