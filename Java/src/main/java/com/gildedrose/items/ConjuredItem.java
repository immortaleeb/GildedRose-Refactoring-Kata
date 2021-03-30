package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredItem extends ExpireableItem {

    private static final int EXPIRATION_RATE = 2;

    public ConjuredItem(Item item) {
        super(item);
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
