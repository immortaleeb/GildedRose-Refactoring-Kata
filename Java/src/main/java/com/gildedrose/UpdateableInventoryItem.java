package com.gildedrose;

interface UpdateableInventoryItem {
    boolean isExpired();

    void updateQuality();

    void updateSellIn();

    void updateExpiredItem();
}
