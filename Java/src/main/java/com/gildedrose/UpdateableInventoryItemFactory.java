package com.gildedrose;

public class UpdateableInventoryItemFactory {

    public static UpdateableInventoryItem createFor(InventoryItem inventoryItem) {
        ItemType itemType = inventoryItem.type();

        switch (itemType) {
            case AGED_BRIE:
                return new AgedBrie(inventoryItem);
            case BACKSTAGE_PASS:
                return new BackstagePass(inventoryItem);
            case LEGENDARY_ITEM:
                return new LegendaryItem(inventoryItem);
            default:
                return new NormalItem(inventoryItem);
        }
    }

}
