package com.gildedrose;

class GildedRose {

    Item[] items;
    private final UpdateableInventoryItemFactory updateableInventoryItemFactory;

    public GildedRose(Item[] items) {
        this(items, new UpdateableInventoryItemFactory());
    }

    public GildedRose(Item[] items, UpdateableInventoryItemFactory updateableInventoryItemFactory) {
        this.items = items;
        this.updateableInventoryItemFactory = updateableInventoryItemFactory;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOf(item);
        }
    }

    private void updateQualityOf(Item item) {
        UpdateableInventoryItem inventoryItem = updateableInventoryItemFactory.createFor(item);

        inventoryItem.updateQuality();

        inventoryItem.updateSellIn();

        if (inventoryItem.isExpired()) {
            inventoryItem.updateExpiredItem();
        }
    }

}