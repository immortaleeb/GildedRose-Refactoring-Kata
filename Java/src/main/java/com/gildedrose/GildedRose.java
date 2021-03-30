package com.gildedrose;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.factory.GildedRoseItemFactory;

class GildedRose {

    Item[] items;
    private final GildedRoseItemFactory gildedRoseItemFactory;

    public GildedRose(Item[] items) {
        this(items, new GildedRoseItemFactory());
    }

    public GildedRose(Item[] items, GildedRoseItemFactory gildedRoseItemFactory) {
        this.items = items;
        this.gildedRoseItemFactory = gildedRoseItemFactory;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOf(item);
        }
    }

    private void updateQualityOf(Item item) {
        GildedRoseItem gildedRoseItem = gildedRoseItemFactory.createFor(item);
        gildedRoseItem.passDay();
    }

}