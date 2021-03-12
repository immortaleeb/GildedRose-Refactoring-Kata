package com.gildedrose;

public class ItemQualityUpdaterFactory {

    public static ItemQualityUpdater createFor(InventoryItem inventoryItem) {
        ItemType itemType = inventoryItem.type();

        switch (itemType) {
            case AGED_BRIE:
                return new AgedBrieItemQualityUpdater(inventoryItem);
            case BACKSTAGE_PASS:
                return new BackstagePassItemQualityUpdater(inventoryItem);
            case LEGENDARY_ITEM:
                return new LegendaryItemQualityUpdater(inventoryItem);
            default:
                return new NormalItemQualityUpdater(inventoryItem);
        }
    }

}
