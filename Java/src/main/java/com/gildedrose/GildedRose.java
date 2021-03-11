package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOf(item);
        }
    }

    private void updateQualityOf(Item item) {
        handleQualityUpdate(item);

        handleSellInUpdate(item);

        if (new InventoryItem(item).isExpired()) {
            handleExpirationUpdate(item);
        }
    }

    private void handleQualityUpdate(Item item) {
        InventoryItem inventoryItem = new InventoryItem(item);

        handleQualityUpdate(inventoryItem);
    }

    private void handleQualityUpdate(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            inventoryItem.increaseQuality();
        } else if (inventoryItem.isBackstagePass()) {
            inventoryItem.increaseQuality();

            if (inventoryItem.sellsIn(11)) {
                inventoryItem.increaseQuality();
            }

            if (inventoryItem.sellsIn(6)) {
                inventoryItem.increaseQuality();
            }
        } else if (inventoryItem.isLegendary()) {
            inventoryItem.increaseQuality();
        } else {
            inventoryItem.decreaseQuality();
        }
    }

    private void handleSellInUpdate(Item item) {
        InventoryItem inventoryItem = new InventoryItem(item);

        handleSellInUpdate(inventoryItem);
    }

    private void handleSellInUpdate(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            inventoryItem.decreaseSellIn();
        } else if (inventoryItem.isBackstagePass()) {
            inventoryItem.decreaseSellIn();
        } else if (inventoryItem.isLegendary()) {
            // do nothing
        } else {
            inventoryItem.decreaseSellIn();
        }
    }

    private void handleExpirationUpdate(Item item) {
        InventoryItem inventoryItem = new InventoryItem(item);

        handleExpirationUpdate(inventoryItem);
    }

    private void handleExpirationUpdate(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            inventoryItem.increaseQuality();
        } else if (inventoryItem.isBackstagePass()) {
            inventoryItem.dropQuality();
        } else if (inventoryItem.isLegendary()) {
            // do nothing
        } else {
            inventoryItem.decreaseQuality();
        }
    }

}