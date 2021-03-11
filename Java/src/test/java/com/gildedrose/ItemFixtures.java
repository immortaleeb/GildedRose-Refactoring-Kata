package com.gildedrose;

public class ItemFixtures {

    public static Item aRegularItem(int sellIn, int quality) {
        return new Item("Regular item", sellIn, quality);
    }

    public static Item agedBrie(int sellIn, int quality) {
        return new Item("Aged Brie", sellIn, quality);
    }

    public static Item aLegendaryItem(int sellIn, int quality) {
        return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    public static Item aBackstagePass(int sellIn, int quality) {
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

}
