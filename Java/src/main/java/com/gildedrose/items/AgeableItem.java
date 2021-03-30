package com.gildedrose.items;

import com.gildedrose.Item;

public class AgeableItem extends ExpireableItem {

    private static final int QUALITY_EXPIRATION_RATE = 1;

    public AgeableItem(Item item) {
        super(item);
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
