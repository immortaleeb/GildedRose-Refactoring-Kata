package com.gildedrose.items;

public interface UpdateableInventoryItem {
    boolean isExpired();

    void updateQuality();

    void updateSellIn();

    void updateExpiredItem();
}
