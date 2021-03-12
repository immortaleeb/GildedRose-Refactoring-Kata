package com.gildedrose.items.helper;

import com.gildedrose.items.helper.ItemType;

public class ItemTypeParser {

    public ItemType parse(String name) {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                return ItemType.LEGENDARY_ITEM;
            case "Backstage passes to a TAFKAL80ETC concert":
                return ItemType.CONCERT_TICKET;
            case "Aged Brie":
                return ItemType.AGEABLE_ITEM;
            default:
                return ItemType.NORMAL_ITEM;
        }
    }

}
