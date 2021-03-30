package com.gildedrose.items;

abstract class ExpireableItem implements UpdateableItem {

    private final InventoryItem inventoryItem;
    private final SellIn sellIn;

    public ExpireableItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
        this.sellIn = new SellIn(inventoryItem.item());
    }

    @Override
    public void update() {
        updateSellIn();
        updateQuality();
    }

    private void updateSellIn() {
        sellIn.decrease();
    }

    private void updateQuality() {
        if (sellIn.isExpired()) {
            updateExpired(inventoryItem);
        } else {
            updateNotExpired(inventoryItem);
        }
    }

    protected abstract void updateExpired(InventoryItem inventoryItem);

    protected abstract void updateNotExpired(InventoryItem inventoryItem);

}
