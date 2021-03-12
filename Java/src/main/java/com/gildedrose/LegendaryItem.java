package com.gildedrose;

class LegendaryItem implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public LegendaryItem(InventoryItem inventoryItem) {
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
        // nothing to do
    }

    @Override
    public void updateExpiredItem() {
        // nothing to do
    }
}
