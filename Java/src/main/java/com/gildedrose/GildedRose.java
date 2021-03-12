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
        ItemQualityUpdater itemQualityUpdater = ItemQualityUpdaterFactory.createFor(inventoryItem);

        itemQualityUpdater.updateQualityOf(inventoryItem);

        itemQualityUpdater.updateSellInOf(inventoryItem);

        if (inventoryItem.isExpired()) {
            itemQualityUpdater.updateExpiredItem(inventoryItem);
        }
    }

    private ItemType parseItemType(Item item) {
        return new ItemTypeParser().parse(item.name);
    }

}