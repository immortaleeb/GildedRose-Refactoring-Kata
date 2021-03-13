package com.gildedrose.items.helper;

public class ItemTypeParser {

    public ItemType parse(String name) {
        if ("Sulfuras, Hand of Ragnaros".equals(name)) {
            return ItemType.LEGENDARY_ITEM;
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            return ItemType.CONCERT_TICKET;
        } else if ("Aged Brie".equals(name)) {
            return ItemType.AGEABLE_ITEM;
        } else if (name.startsWith("Conjured ")) {
            return ItemType.CONJURED_ITEM;
        }

        return ItemType.NORMAL_ITEM;
    }

}
