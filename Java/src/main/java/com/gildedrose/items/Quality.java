package com.gildedrose.items;

import com.gildedrose.Item;

class Quality {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private final Item item;

    public Quality(Item item) {
        this.item = item;
    }

    public void increase(int increment) {
        item.quality = Math.min(MAX_QUALITY, item.quality + increment);
    }

    public void decrease(int decrement) {
        item.quality = Math.max(MIN_QUALITY, item.quality - decrement);
    }

    public void drop() {
        item.quality = MIN_QUALITY;
    }

}
