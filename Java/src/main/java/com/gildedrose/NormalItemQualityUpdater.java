package com.gildedrose;

class NormalItemQualityUpdater implements ItemQualityUpdater {

    private final InventoryItem inventoryItem;

    public NormalItemQualityUpdater(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateQualityOf(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality();
    }

    @Override
    public void updateSellInOf(InventoryItem inventoryItem) {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateExpiredItem(InventoryItem inventoryItem) {
        inventoryItem.decreaseQuality();
    }
}
