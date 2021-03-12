package com.gildedrose;

class NormalItemQualityUpdater implements ItemQualityUpdater {

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
