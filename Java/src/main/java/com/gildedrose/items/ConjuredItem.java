package com.gildedrose.items;

public class ConjuredItem extends ExpireableItem {

    private static final int EXPIRATION_RATE = 2;

    public ConjuredItem(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(SellIn sellIn, Quality quality) {
        quality.decrease(2 * EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(SellIn sellIn, Quality quality) {
        quality.decrease(EXPIRATION_RATE);
    }

}
