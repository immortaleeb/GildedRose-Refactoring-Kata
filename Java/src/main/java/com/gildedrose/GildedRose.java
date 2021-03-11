package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOf(item);
        }
    }

    private void updateQualityOf(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseQuality(item);
        } else {
            if (item.quality < 50) {
                increaseQuality(item);
            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        increaseQuality(item);
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        increaseQuality(item);
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
                    }
                } else {
                    dropQuality(item);
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void dropQuality(Item item) {
        item.quality = 0;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

}