package com.gildedrose.items;

import com.gildedrose.items.helper.InventoryItem;

public class ConcertTicket extends ExpireableItem {

    private static final int IN_10_DAYS = 10;
    private static final int IN_5_DAYS = 5;

    public ConcertTicket(InventoryItem inventoryItem) {
        super(inventoryItem);
    }

    @Override
    protected void updateExpired(InventoryItem inventoryItem) {
        inventoryItem.dropQuality();
    }

    @Override
    protected void updateNotExpired(InventoryItem inventoryItem) {
        int expirationRate = decideExpirationRateOf(inventoryItem);
        inventoryItem.increaseQuality(expirationRate);
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
