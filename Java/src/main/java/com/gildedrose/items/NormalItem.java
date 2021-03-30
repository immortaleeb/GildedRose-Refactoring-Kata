package com.gildedrose.items;

public class NormalItem extends ExpireableItem {

    private static final int QUALITY_EXPIRATION_RATE = 1;

    private final Quality quality;

    public NormalItem(InventoryItem inventoryItem) {
        super(inventoryItem);
        quality = new Quality(inventoryItem.item());
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        quality.decrease(2 * QUALITY_EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        quality.decrease(QUALITY_EXPIRATION_RATE);
    }

}
