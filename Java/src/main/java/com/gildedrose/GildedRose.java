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

        itemQualityUpdater.updateQuality();

        itemQualityUpdater.updateSellIn();

        if (inventoryItem.isExpired()) {
            itemQualityUpdater.updateExpiredItem();
        }
    }

    private ItemType parseItemType(Item item) {
        return new ItemTypeParser().parse(item.name);
    }

}