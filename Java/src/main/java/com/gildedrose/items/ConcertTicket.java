package com.gildedrose.items;

public class ConcertTicket extends ExpireableItem {

    private static final int IN_10_DAYS = 10;
    private static final int IN_5_DAYS = 5;

    public ConcertTicket(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(SellIn sellIn, Quality quality) {
        quality.drop();
    }

    @Override
    protected void updateNotExpired(SellIn sellIn, Quality quality) {
        int expirationRate = decideExpirationRateOf(sellIn);
        quality.increase(expirationRate);
    }

    private int decideExpirationRateOf(SellIn sellIn) {
        if (sellIn.within(IN_5_DAYS)) {
            return 3;
        } else if (sellIn.within(IN_10_DAYS)) {
            return 2;
        }

        return 1;
    }

}
