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
        InventoryItem inventoryItem = parse(item);
        UpdateableInventoryItemFactory factory = new UpdateableInventoryItemFactory();

        UpdateableInventoryItem updateableInventoryItem = factory.createFor(inventoryItem);

        updateableInventoryItem.updateQuality();

        updateableInventoryItem.updateSellIn();

        if (inventoryItem.isExpired()) {
            updateableInventoryItem.updateExpiredItem();
        }
    }

    private InventoryItem parse(Item item) {
        InventoryItemFactory factory = new InventoryItemFactory();
        return factory.createFor(item);
    }

}