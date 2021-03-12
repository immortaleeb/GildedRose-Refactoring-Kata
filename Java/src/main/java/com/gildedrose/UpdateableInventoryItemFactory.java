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
            case AGEABLE_ITEM:
                return new AgeableItem(inventoryItem);
            case CONCERT_TICKET:
                return new ConcertTicket(inventoryItem);
            case LEGENDARY_ITEM:
                return new LegendaryItem(inventoryItem);
            default:
                return new NormalItem(inventoryItem);
        }
    }

}
