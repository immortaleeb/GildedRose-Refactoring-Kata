package com.gildedrose.items.factory;

import com.gildedrose.Item;
import com.gildedrose.items.AgeableItem;
import com.gildedrose.items.ConcertTicket;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.UpdateableItem;
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

    public UpdateableItem createFor(Item item) {
        ItemType itemType = itemTypeParser.parse(item.name);
        InventoryItem inventoryItem = new InventoryItem(item);

        return createFor(itemType, inventoryItem);
    }

    private UpdateableItem createFor(ItemType itemType, InventoryItem inventoryItem) {
        switch (itemType) {
            case AGEABLE_ITEM:
                return new AgeableItem(inventoryItem);
            case CONCERT_TICKET:
                return new ConcertTicket(inventoryItem);
            case LEGENDARY_ITEM:
                return new LegendaryItem();
            case CONJURED_ITEM:
                return new ConjuredItem(inventoryItem);
            case NORMAL_ITEM:
                return new NormalItem(inventoryItem);
            default:
                throw new IllegalArgumentException("Cannot create updateable item for unknown type " + itemType);
        }
    }

}
