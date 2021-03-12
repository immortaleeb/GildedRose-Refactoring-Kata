package com.gildedrose;

class AgedBrieItemQualityUpdater implements ItemQualityUpdater {

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
