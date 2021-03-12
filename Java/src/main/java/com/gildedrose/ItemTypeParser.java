package com.gildedrose;

public class ItemTypeParser {

    public boolean isLegendary(String name) {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isBackstagePass(String name) {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isAgedBrie(String name) {
        return name.equals("Aged Brie");
    }

}
