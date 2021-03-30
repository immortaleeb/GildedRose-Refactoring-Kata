package com.gildedrose.items;

public class AgeableItem extends ExpireableItem {

    private static final int QUALITY_EXPIRATION_RATE = 1;

    private final Quality quality;

    public AgeableItem(InventoryItem inventoryItem) {
        super(inventoryItem);
        this.quality = new Quality(inventoryItem.item());
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        quality.increase(2 * QUALITY_EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        quality.increase(QUALITY_EXPIRATION_RATE);
    }

}
