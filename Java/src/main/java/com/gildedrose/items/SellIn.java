package com.gildedrose.items;

import com.gildedrose.Item;

class SellIn {

    private final Item item;

    public SellIn(Item item) {
        this.item = item;
    }

    public void decrease() {
        item.sellIn = item.sellIn - 1;
    }

    public boolean isExpired() {
        return item.sellIn < 0;
    }

    public boolean within(int numberOfDays) {
        return item.sellIn < numberOfDays;
    }

}
