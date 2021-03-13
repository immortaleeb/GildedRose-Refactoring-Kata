package com.gildedrose.items;

public interface UpdateableInventoryItem {

    default void update() {
        updateSellIn();
        updateQuality();
    }

    void updateSellIn();

    void updateQuality();

}
