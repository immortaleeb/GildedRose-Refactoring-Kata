package com.gildedrose.items;

public interface UpdateableInventoryItem {
    boolean isExpired();

    void updateSellIn();

    void updateQuality();

    void updateExpiredItem();
}
