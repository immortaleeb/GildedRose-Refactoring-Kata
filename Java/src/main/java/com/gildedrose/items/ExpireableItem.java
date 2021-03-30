package com.gildedrose.items;

abstract class ExpireableItem implements UpdateableItem {

    private final InventoryItem inventoryItem;

    public ExpireableItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public void update() {
        updateSellIn();
        updateQuality();
    }

    private void updateSellIn() {
        inventoryItem.decreaseSellIn();
    }

    private void updateQuality() {
        if (inventoryItem.isExpired()) {
            updateExpired(inventoryItem);
        } else {
            updateNotExpired(inventoryItem);
        }
    }

    protected abstract void updateExpired(InventoryItem inventoryItem);

    protected abstract void updateNotExpired(InventoryItem inventoryItem);

}
