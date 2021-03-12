package com.gildedrose.items.helper;

import com.gildedrose.Item;
import com.gildedrose.ItemFixtures;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class InventoryItemTest {

    @Test
    void increaseQuality_increases_quality_by_1() {
        Item item = ItemFixtures.aRegularItem(10, 5);
        InventoryItem inventoryItem = new InventoryItem(item, ItemType.NORMAL_ITEM);

        inventoryItem.increaseQuality();

        assertThat(item.quality, is(equalTo(5 + 1)));
    }

    @Test
    void increaseQuality_does_not_increase_quality_above_50() {
        Item item = ItemFixtures.aRegularItem(10, 50);
        InventoryItem inventoryItem = new InventoryItem(item, ItemType.NORMAL_ITEM);

        inventoryItem.increaseQuality();

        assertThat(item.quality, is(equalTo(50)));
    }

    @Test
    void decreaseQuality_decreases_quality_by_1() {
        Item item = ItemFixtures.aRegularItem(10, 5);
        InventoryItem inventoryItem = new InventoryItem(item, ItemType.NORMAL_ITEM);

        inventoryItem.decreaseQuality();

        assertThat(item.quality, is(equalTo(5 - 1)));
    }

    @Test
    void decreaseQuality_cannot_decrease_quality_below_0() {
        Item item = ItemFixtures.aRegularItem(10, 0);
        InventoryItem inventoryItem = new InventoryItem(item, ItemType.NORMAL_ITEM);

        inventoryItem.decreaseQuality();

        assertThat(item.quality, is(equalTo(0)));
    }

}