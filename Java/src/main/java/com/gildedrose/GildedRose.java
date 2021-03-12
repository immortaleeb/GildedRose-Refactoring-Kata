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
        InventoryItem inventoryItem = new InventoryItem(item, parseItemType(item));
        UpdateableInventoryItem updateableInventoryItem = UpdateableInventoryItemFactory.createFor(inventoryItem);

        updateableInventoryItem.updateQuality();

        updateableInventoryItem.updateSellIn();

        if (inventoryItem.isExpired()) {
            updateableInventoryItem.updateExpiredItem();
        }
    }

    private ItemType parseItemType(Item item) {
        return new ItemTypeParser().parse(item.name);
    }

}