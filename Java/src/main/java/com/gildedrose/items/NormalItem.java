package com.gildedrose.items;

import com.gildedrose.Item;

public class NormalItem extends ExpireableItem {

    private static final int QUALITY_EXPIRATION_RATE = 1;

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    protected void updateExpired(SellIn sellIn, Quality quality) {
        quality.decrease(2 * QUALITY_EXPIRATION_RATE);
    }

    @Override
    protected void updateNotExpired(SellIn sellIn, Quality quality) {
        quality.decrease(QUALITY_EXPIRATION_RATE);
    }

}
