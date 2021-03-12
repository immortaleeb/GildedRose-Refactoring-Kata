package com.gildedrose;

interface ItemQualityUpdater {
    void updateQualityOf(InventoryItem inventoryItem);

    void updateSellInOf(InventoryItem inventoryItem);

    void updateExpiredItem(InventoryItem inventoryItem);
}
