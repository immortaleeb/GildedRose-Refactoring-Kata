package com.gildedrose;

class LegendaryItemQualityUpdater implements ItemQualityUpdater {

    private final InventoryItem inventoryItem;

    public LegendaryItemQualityUpdater(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateQualityOf(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality();
    }

    @Override
    public void updateSellInOf(InventoryItem inventoryItem) {
        // nothing to do
    }

    @Override
    public void updateExpiredItem(InventoryItem inventoryItem) {
        // nothing to do
    }
}
