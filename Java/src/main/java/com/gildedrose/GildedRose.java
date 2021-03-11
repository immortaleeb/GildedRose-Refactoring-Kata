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
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePass(item)) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else if (isLegendary(item)) {
            increaseQuality(item);
        } else {
            decreaseQuality(item);
        }
    }

    private void handleSellInUpdate(Item item) {
        if (isAgedBrie(item)) {
            decreaseSellIn(item);
        } else if (isBackstagePass(item)) {
            decreaseSellIn(item);
        } else if (isLegendary(item)) {
            // do nothing
        } else {
            decreaseSellIn(item);
        }
    }

    private void handleExpirationUpdate(Item item) {
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isBackstagePass(item)) {
            dropQuality(item);
        } else if (isLegendary(item)) {
            // do nothing
        } else {
            decreaseQuality(item);
        }
    }

    private boolean isLegendary(Item item) {
        return new InventoryItem(item).isLegendary();
    }

    private boolean isBackstagePass(Item item) {
        return new InventoryItem(item).isBackstagePass();
    }

    private boolean isAgedBrie(Item item) {
        return new InventoryItem(item).isAgedBrie();
    }

    private void decreaseSellIn(Item item) {
        new InventoryItem(item).decreaseSellIn();
    }

    private boolean isExpired(Item item) {
        return new InventoryItem(item).isExpired();
    }

    private void increaseQuality(Item item) {
        new InventoryItem(item).increaseQuality();
    }

    private void decreaseQuality(Item item) {
        new InventoryItem(item).decreaseQuality();
    }

    private void dropQuality(Item item) {
        new InventoryItem(item).dropQuality();
    }

    private static class InventoryItem {
        private final Item item;

        public InventoryItem(Item item) {
            this.item = item;
        }

        private boolean isLegendary() {
            return item.name.equals("Sulfuras, Hand of Ragnaros");
        }

        private boolean isBackstagePass() {
            return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        }

        private boolean isAgedBrie() {
            return item.name.equals("Aged Brie");
        }

        private void decreaseSellIn() {
            item.sellIn = item.sellIn - 1;
        }

        private boolean isExpired() {
            return item.sellIn < 0;
        }

        private void increaseQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        private void decreaseQuality() {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        private void dropQuality() {
            item.quality = 0;
        }
    }

}