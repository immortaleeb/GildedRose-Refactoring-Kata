package com.gildedrose.items;

public class ConcertTicket extends ExpireableItem {

    private static final int IN_10_DAYS = 10;
    private static final int IN_5_DAYS = 5;

    private final Quality quality;

    public ConcertTicket(InventoryItem inventoryItem) {
        super(inventoryItem);
        quality = new Quality(inventoryItem.item());
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        quality.drop();
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        int expirationRate = decideExpirationRateOf(inventoryItem);
        quality.increase(expirationRate);
    }

    private int decideExpirationRateOf(InventoryItem inventoryItem) {
        if (inventoryItem.sellsIn(IN_5_DAYS)) {
            return 3;
        } else if (inventoryItem.sellsIn(IN_10_DAYS)) {
            return 2;
        }

        return 1;
    }

}
