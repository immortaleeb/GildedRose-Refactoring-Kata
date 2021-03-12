package com.gildedrose;

class AgedBrieItemQualityUpdater implements ItemQualityUpdater {

    private final InventoryItem inventoryItem;

    public AgedBrieItemQualityUpdater(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateQuality() {
        inventoryItem.increaseQuality();
    }

    @Override
    public void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateExpiredItem() {
        inventoryItem.increaseQuality();
    }

}
