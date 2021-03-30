package com.gildedrose.items.factory;

import com.gildedrose.Item;
import com.gildedrose.items.AgeableItem;
import com.gildedrose.items.ConcertTicket;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.GildedRoseItem;

public class GildedRoseItemFactory {

    private final ItemTypeParser itemTypeParser;

    public GildedRoseItemFactory() {
        this.itemTypeParser = new ItemTypeParser();
    }

    public GildedRoseItem createFor(Item item) {
        ItemType itemType = itemTypeParser.parse(item.name);

        return createFor(itemType, item);
    }

    private GildedRoseItem createFor(ItemType itemType, Item item) {
        switch (itemType) {
            case AGEABLE_ITEM:
                return new AgeableItem(item);
            case CONCERT_TICKET:
                return new ConcertTicket(item);
            case LEGENDARY_ITEM:
                return new LegendaryItem();
            case CONJURED_ITEM:
                return new ConjuredItem(item);
            case NORMAL_ITEM:
                return new NormalItem(item);
            default:
                throw new IllegalArgumentException("Cannot create gilded rose item for unknown type " + itemType);
        }
    }

}
