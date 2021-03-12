package com.gildedrose;

class LegendaryItemQualityUpdater implements ItemQualityUpdater {

    private final InventoryItem inventoryItem;

    public LegendaryItemQualityUpdater(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateQuality() {
        inventoryItem.increaseQuality();
    }

    @Override
    public void updateSellIn() {
        // nothing to do
    }

    @Override
    public void updateExpiredItem() {
        // nothing to do
    }
}
