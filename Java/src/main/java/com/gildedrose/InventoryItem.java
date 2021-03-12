package com.gildedrose;

class InventoryItem {
    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public boolean isLegendary() {
        return new ItemTypeParser().parse(item.name).equals(ItemType.LEGENDARY_ITEM);
    }

    public boolean isBackstagePass() {
        return new ItemTypeParser().parse(item.name).equals(ItemType.BACKSTAGE_PASS);
    }

    public boolean isAgedBrie() {
        return new ItemTypeParser().parse(item.name).equals(ItemType.AGED_BRIE);
    }

    public void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    public boolean isExpired() {
        return item.sellIn < 0;
    }

    public void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public void dropQuality() {
        item.quality = 0;
    }

    public boolean sellsIn(int numberOfDays) {
        return item.sellIn < numberOfDays;
    }
    
}
