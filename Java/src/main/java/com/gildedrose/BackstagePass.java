package com.gildedrose;

class BackstagePass implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public BackstagePass(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void updateQuality() {
        inventoryItem.increaseQuality();

        if (inventoryItem.sellsIn(11)) {
            inventoryItem.increaseQuality();
        }

        if (inventoryItem.sellsIn(6)) {
            inventoryItem.increaseQuality();
        }
    }

    @Override
    public void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    @Override
    public void updateExpiredItem() {
        inventoryItem.dropQuality();
    }
}
