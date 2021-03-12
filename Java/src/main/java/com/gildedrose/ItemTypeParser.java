package com.gildedrose;

public class ItemTypeParser {

    public boolean isLegendary(String name) {
        return parse(name).equals(ItemType.LEGENDARY_ITEM);
    }

    public boolean isBackstagePass(String name) {
        return parse(name).equals(ItemType.BACKSTAGE_PASS);
    }

    public boolean isAgedBrie(String name) {
        return parse(name).equals(ItemType.AGED_BRIE);
    }

    private ItemType parse(String name) {
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            return ItemType.LEGENDARY_ITEM;
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return ItemType.BACKSTAGE_PASS;
        } else if (name.equals("Aged Brie")) {
            return ItemType.AGED_BRIE;
        } else {
            return ItemType.NORMAL_ITEM;
        }
    }

}
