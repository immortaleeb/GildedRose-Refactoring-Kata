package com.gildedrose.items.factory;

import com.gildedrose.Item;
import com.gildedrose.items.AgeableItem;
import com.gildedrose.items.ConcertTicket;
import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.UpdateableInventoryItem;
import com.gildedrose.items.helper.InventoryItem;
import com.gildedrose.items.helper.ItemType;
import com.gildedrose.items.helper.ItemTypeParser;

public class UpdateableInventoryItemFactory {

    private final ItemTypeParser itemTypeParser;

    public UpdateableInventoryItemFactory(ItemTypeParser itemTypeParser) {
        this.itemTypeParser = itemTypeParser;
    }

    public UpdateableInventoryItemFactory() {
        this(new ItemTypeParser());
    }

    public UpdateableInventoryItem createFor(Item item) {
        ItemType itemType = itemTypeParser.parse(item.name);
        InventoryItem inventoryItem = new InventoryItem(item);

        return createFor(itemType, inventoryItem);
    }

    private UpdateableInventoryItem createFor(ItemType itemType, InventoryItem inventoryItem) {
        switch (itemType) {
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
