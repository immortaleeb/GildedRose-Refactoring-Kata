package com.gildedrose;

class BackstagePassItemQualityUpdater implements ItemQualityUpdater {

    @Override
    public void updateQualityOf(InventoryItem inventoryItem) {
        inventoryItem.increaseQuality();

        if (inventoryItem.sellsIn(11)) {
            inventoryItem.increaseQuality();
        }

        if (inventoryItem.sellsIn(6)) {
            inventoryItem.increaseQuality();
        }
    }

    @Override
    public void updateSellInOf(InventoryItem inventoryItem) {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateExpiredItem(InventoryItem inventoryItem) {
        inventoryItem.dropQuality();
    }
}
