package com.gildedrose.items;

import com.gildedrose.Item;

abstract class ExpireableItem implements UpdateableItem {

    private final Quality quality;
    private final SellIn sellIn;

    public ExpireableItem(Item item) {
        this.quality = new Quality(item);
        this.sellIn = new SellIn(item);
    }

    @Override
    public void passDay() {
        updateSellIn();
        updateQuality();
    }

    private void updateSellIn() {
        sellIn.decrease();
    }

    private void updateQuality() {
        if (sellIn.isExpired()) {
            updateExpired(sellIn, quality);
        } else {
            updateNotExpired(sellIn, quality);
        }
    }

    protected abstract void updateExpired(SellIn sellIn, Quality quality);

    protected abstract void updateNotExpired(SellIn sellIn, Quality quality);

}
