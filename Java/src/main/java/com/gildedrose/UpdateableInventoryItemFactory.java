package com.gildedrose;

public class UpdateableInventoryItemFactory {

    private final InventoryItemFactory inventoryItemFactory;

    public UpdateableInventoryItemFactory() {
        this(new InventoryItemFactory());
    }

    public UpdateableInventoryItemFactory(InventoryItemFactory inventoryItemFactory) {
        this.inventoryItemFactory = inventoryItemFactory;
    }

    public UpdateableInventoryItem createFor(Item item) {
        InventoryItem inventoryItem = inventoryItemFactory.createFor(item);
        return createFor(inventoryItem);
    }

    private UpdateableInventoryItem createFor(InventoryItem inventoryItem) {
        switch (inventoryItem.type()) {
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
