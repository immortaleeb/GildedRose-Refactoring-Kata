package com.gildedrose.items;

public class AgeableItem extends ExpireableItem {

    private static final int QUALITY_EXPIRATION_RATE = 1;

    public AgeableItem(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(SellIn sellIn, Quality quality) {
        quality.increase(2 * QUALITY_EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(SellIn sellIn, Quality quality) {
        quality.increase(QUALITY_EXPIRATION_RATE);
    }

}
