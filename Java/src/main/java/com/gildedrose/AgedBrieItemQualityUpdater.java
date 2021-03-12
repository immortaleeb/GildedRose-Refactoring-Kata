package com.gildedrose;

class AgedBrieItemQualityUpdater implements ItemQualityUpdater {

    private final InventoryItem inventoryItem;

    public AgedBrieItemQualityUpdater(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateQualityOf(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality();
    }

    @Override
    public void updateSellInOf(InventoryItem inventoryItem) {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateExpiredItem(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality();
    }

}
