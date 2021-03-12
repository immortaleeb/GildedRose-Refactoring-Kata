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
        InventoryItem inventoryItem = new InventoryItem(item);

        handleQualityUpdate(inventoryItem);

        handleSellInUpdate(inventoryItem);

        if (inventoryItem.isExpired()) {
            handleExpirationUpdate(inventoryItem);
        }
    }

    private void handleQualityUpdate(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            new AgedBrieItemQualityUpdater().updateQualityOf(inventoryItem);
        } else if (inventoryItem.isBackstagePass()) {
            new BackstagePassItemQualityUpdater().updateQualityOf(inventoryItem);
        } else if (inventoryItem.isLegendary()) {
            new LegendaryItemQualityUpdater().updateQualityOf(inventoryItem);
        } else {
            new NormalItemQualityUpdater().updateQualityOf(inventoryItem);
        }
    }

    private void handleSellInUpdate(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            inventoryItem.decreaseSellIn();
        } else if (inventoryItem.isBackstagePass()) {
            inventoryItem.decreaseSellIn();
        } else if (inventoryItem.isLegendary()) {
            // do nothing
        } else {
            inventoryItem.decreaseSellIn();
        }
    }

    private void handleExpirationUpdate(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            inventoryItem.increaseQuality();
        } else if (inventoryItem.isBackstagePass()) {
            inventoryItem.dropQuality();
        } else if (inventoryItem.isLegendary()) {
            // do nothing
        } else {
            inventoryItem.decreaseQuality();
        }
    }

    private interface ItemQualityUpdater {
        void updateQualityOf(InventoryItem inventoryItem);
    }

    private static class AgedBrieItemQualityUpdater implements ItemQualityUpdater {

        @Override
        public void updateQualityOf(InventoryItem inventoryItem) {
            inventoryItem.increaseQuality();
        }

    }

    private static class BackstagePassItemQualityUpdater implements ItemQualityUpdater {

        @Override
        public void updateQualityOf(InventoryItem inventoryItem) {
            inventoryItem.increaseQuality();

            if (inventoryItem.sellsIn(11)) {
                inventoryItem.increaseQuality();
            }

            if (inventoryItem.sellsIn(6)) {
                inventoryItem.increaseQuality();
            }
        }
    }

    private static class LegendaryItemQualityUpdater implements ItemQualityUpdater {

        @Override
        public void updateQualityOf(InventoryItem inventoryItem) {
            inventoryItem.increaseQuality();
        }
    }

    private static class NormalItemQualityUpdater implements ItemQualityUpdater {

        @Override
        public void updateQualityOf(InventoryItem inventoryItem) {
            inventoryItem.decreaseQuality();
        }
    }

}