package com.gildedrose;

class NormalItemQualityUpdater implements ItemQualityUpdater {

    private final InventoryItem inventoryItem;

    public NormalItemQualityUpdater(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateQuality() {
        inventoryItem.decreaseQuality();
    }

    @Override
    public void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateExpiredItem() {
        inventoryItem.decreaseQuality();
    }
}
