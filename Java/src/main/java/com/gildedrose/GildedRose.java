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
        UpdateableInventoryItemFactory factory = new UpdateableInventoryItemFactory();

        UpdateableInventoryItem inventoryItem = factory.createFor(item);

        inventoryItem.updateQuality();

        inventoryItem.updateSellIn();

        if (inventoryItem.isExpired()) {
            inventoryItem.updateExpiredItem();
        }
    }

}