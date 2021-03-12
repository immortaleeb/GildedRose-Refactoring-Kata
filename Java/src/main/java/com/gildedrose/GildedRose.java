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
        InventoryItem inventoryItem = new InventoryItem(item);

        handleQualityUpdate(inventoryItem);

        handleSellInUpdate(inventoryItem);

        if (inventoryItem.isExpired()) {
            handleExpirationUpdate(inventoryItem);
        }
    }

    private void handleQualityUpdate(InventoryItem inventoryItem) {
        ItemQualityUpdater itemQualityUpdater = createItemQualityUpdater(inventoryItem);
        itemQualityUpdater.updateQualityOf(inventoryItem);
    }

    private ItemQualityUpdater createItemQualityUpdater(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            return new AgedBrieItemQualityUpdater();
        } else if (inventoryItem.isBackstagePass()) {
            return new BackstagePassItemQualityUpdater();
        } else if (inventoryItem.isLegendary()) {
            return new LegendaryItemQualityUpdater();
        } else {
            return new NormalItemQualityUpdater();
        }
    }

    private void handleSellInUpdate(InventoryItem inventoryItem) {
        ItemQualityUpdater itemQualityUpdater = createItemQualityUpdater(inventoryItem);
        itemQualityUpdater.updateSellInOf(inventoryItem);
    }

    private void handleExpirationUpdate(InventoryItem inventoryItem) {
        ItemQualityUpdater itemQualityUpdater = createItemQualityUpdater(inventoryItem);
        itemQualityUpdater.updateExpiredItem(inventoryItem);
    }

}