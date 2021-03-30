package com.gildedrose.items;

public class ConcertTicket extends ExpireableItem {

    private static final int IN_10_DAYS = 10;
    private static final int IN_5_DAYS = 5;

    private final Quality quality;
    private final SellIn sellIn;

    public ConcertTicket(InventoryItem inventoryItem) {
        super(inventoryItem);

        quality = new Quality(inventoryItem.item());
        sellIn = new SellIn(inventoryItem.item());
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        quality.drop();
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        int expirationRate = decideExpirationRateOf();
        quality.increase(expirationRate);
    }

    private int decideExpirationRateOf() {
        if (sellIn.within(IN_5_DAYS)) {
            return 3;
        } else if (sellIn.within(IN_10_DAYS)) {
            return 2;
        }

        return 1;
    }

}
