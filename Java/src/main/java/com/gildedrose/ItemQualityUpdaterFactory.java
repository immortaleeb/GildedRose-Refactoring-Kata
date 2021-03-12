package com.gildedrose;

public class ItemQualityUpdaterFactory {

    public static ItemQualityUpdater createFor(InventoryItem inventoryItem) {
        ItemType itemType = inventoryItem.type();

        switch (itemType) {
            case AGED_BRIE:
                return new AgedBrieItemQualityUpdater();
            case BACKSTAGE_PASS:
                return new BackstagePassItemQualityUpdater();
            case LEGENDARY_ITEM:
                return new LegendaryItemQualityUpdater();
            default:
                return new NormalItemQualityUpdater();
        }
    }

}
