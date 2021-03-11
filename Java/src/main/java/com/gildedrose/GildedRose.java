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
        handleQualityUpdate(item);

        handleSellInUpdate(item);

        if (isExpired(item)) {
            handleExpirationUpdate(item);
        }
    }

    private void handleQualityUpdate(Item item) {
        if (isAgedBrie(item) || isBackstagePass(item) || isLegendary(item)) {
            increaseQuality(item);
        } else {
            decreaseQuality(item);
        }

        if (isBackstagePass(item)) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private void handleSellInUpdate(Item item) {
        if (!isLegendary(item)) {
            decreaseSellIn(item);
        }
    }

    private void handleExpirationUpdate(Item item) {
        if (!isAgedBrie(item)) {
            if (!isBackstagePass(item)) {
                if (!isLegendary(item)) {
                    decreaseQuality(item);
                }
            } else {
                dropQuality(item);
            }
        } else {
            increaseQuality(item);
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
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

}