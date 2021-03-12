package com.gildedrose;

public class InventoryItemFactory {

    private final ItemTypeParser itemTypeParser;

    public InventoryItemFactory() {
        this.itemTypeParser = new ItemTypeParser();
    }

    public InventoryItemFactory(ItemTypeParser itemTypeParser) {
        this.itemTypeParser = itemTypeParser;
    }

    public InventoryItem createFor(Item item) {
        ItemType itemType = itemTypeParser.parse(item.name);

        return new InventoryItem(item, itemType);
    }

}
