package com.gildedrose;

class NormalItem implements UpdateableInventoryItem {

    private final InventoryItem inventoryItem;

    public NormalItem(InventoryItem inventoryItem) {
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
