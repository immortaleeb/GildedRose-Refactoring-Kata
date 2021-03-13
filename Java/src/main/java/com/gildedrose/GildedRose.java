package com.gildedrose;

import com.gildedrose.items.UpdateableItem;
import com.gildedrose.items.factory.UpdateableInventoryItemFactory;

class GildedRose {

    Item[] items;
    private final UpdateableInventoryItemFactory updateableInventoryItemFactory;

    public GildedRose(Item[] items) {
        this(items, new UpdateableInventoryItemFactory());
    }

    public GildedRose(Item[] items, UpdateableInventoryItemFactory updateableInventoryItemFactory) {
        this.items = items;
        this.updateableInventoryItemFactory = updateableInventoryItemFactory;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOf(item);
        }
    }

    private void updateQualityOf(Item item) {
        UpdateableItem updateableItem = updateableInventoryItemFactory.createFor(item);
        updateableItem.update();
    }

}