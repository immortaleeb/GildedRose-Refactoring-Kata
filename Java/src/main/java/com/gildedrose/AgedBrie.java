package com.gildedrose;

class AgedBrie implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public AgedBrie(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public boolean isExpired() {
        return inventoryItem.isExpired();
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
