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
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                return ItemType.LEGENDARY_ITEM;
            case "Backstage passes to a TAFKAL80ETC concert":
                return ItemType.BACKSTAGE_PASS;
            case "Aged Brie":
                return ItemType.AGED_BRIE;
            default:
                return ItemType.NORMAL_ITEM;
        }
    }

}
