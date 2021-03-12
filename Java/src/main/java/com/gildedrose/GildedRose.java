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
        ItemQualityUpdater itemQualityUpdater = createItemQualityUpdater(inventoryItem);
        itemQualityUpdater.updateQualityOf(inventoryItem);
    }

    private ItemQualityUpdater createItemQualityUpdater(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            return new AgedBrieItemQualityUpdater();
        } else if (inventoryItem.isBackstagePass()) {
            return new BackstagePassItemQualityUpdater();
        } else if (inventoryItem.isLegendary()) {
            return new LegendaryItemQualityUpdater();
        } else {
            return new NormalItemQualityUpdater();
        }
    }

    private void handleSellInUpdate(InventoryItem inventoryItem) {
        if (inventoryItem.isAgedBrie()) {
            new AgedBrieItemQualityUpdater().updateSellInOf(inventoryItem);
        } else if (inventoryItem.isBackstagePass()) {
            new BackstagePassItemQualityUpdater().updateSellInOf(inventoryItem);
        } else if (inventoryItem.isLegendary()) {
            new LegendaryItemQualityUpdater().updateSellInOf(inventoryItem);
        } else {
            new NormalItemQualityUpdater().updateSellInOf(inventoryItem);
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

        void updateSellInOf(InventoryItem inventoryItem);
    }

    private static class AgedBrieItemQualityUpdater implements ItemQualityUpdater {

        @Override
        public void updateQualityOf(InventoryItem inventoryItem) {
            inventoryItem.increaseQuality();
        }

        @Override
        public void updateSellInOf(InventoryItem inventoryItem) {
            inventoryItem.decreaseSellIn();
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

        @Override
        public void updateSellInOf(InventoryItem inventoryItem) {
            inventoryItem.decreaseSellIn();
        }
    }

    private static class LegendaryItemQualityUpdater implements ItemQualityUpdater {

        @Override
        public void updateQualityOf(InventoryItem inventoryItem) {
            inventoryItem.increaseQuality();
        }

        @Override
        public void updateSellInOf(InventoryItem inventoryItem) {
            // nothing to do
        }
    }

    private static class NormalItemQualityUpdater implements ItemQualityUpdater {

        @Override
        public void updateQualityOf(InventoryItem inventoryItem) {
            inventoryItem.decreaseQuality();
        }

        @Override
        public void updateSellInOf(InventoryItem inventoryItem) {
            inventoryItem.decreaseSellIn();
        }
    }

}