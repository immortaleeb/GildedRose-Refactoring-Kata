package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemFixtures.aBackstagePass;
import static com.gildedrose.ItemFixtures.aLegendaryItem;
import static com.gildedrose.ItemFixtures.aRegularItem;
import static com.gildedrose.ItemFixtures.agedBrie;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class GildedRoseTest {

    @Test
    void updateQuality_reduces_sellIn_by_1_for_regular_item() {
        Item item = aRegularItem(10, 5);

        updateQualityOf(item);

        assertThat(item.sellIn, is(equalTo(9)));
    }

    @Test
    void updateQuality_reduces_quality_by_1_for_regular_item() {
        Item item = aRegularItem(10, 5);

        updateQualityOf(item);

        assertThat(item.quality, is(equalTo(4)));
    }

    @Test
    void updateQuality_reduces_quality_by_2_for_expired_regular_item() {
        Item expiredItem = aRegularItem(0, 5);

        updateQualityOf(expiredItem);

        assertThat(expiredItem.quality, is(equalTo(3)));
    }

    @Test
    void updateQuality_cannot_update_quality_below_0() {
        Item item = aRegularItem(5, 0);

        updateQualityOf(item);

        assertThat(item.quality, is(equalTo(0)));
    }

    @Test
    void updateQuality_increases_quality_by_1_for_aged_brie() {
        Item agedBrie = agedBrie(5, 3);

        updateQualityOf(agedBrie);

        assertThat(agedBrie.quality, is(equalTo(4)));
    }

    @Test
    void updateQuality_increases_quality_by_2_for_expired_aged_brie() {
        Item expiredAgedBrie = agedBrie(0, 3);

        updateQualityOf(expiredAgedBrie);

        assertThat(expiredAgedBrie.quality, is(equalTo(5)));
    }

    @Test
    void updateQuality_does_nothing_for_legendary_item() {
        Item legendaryItem = aLegendaryItem(0, 80);

        updateQualityOf(legendaryItem);

        assertThat(legendaryItem.quality, is(equalTo(80)));
        assertThat(legendaryItem.sellIn, is(equalTo(0)));
    }

    @Test
    void updateQuality_increases_quality_by_1_for_backstage_pass_sold_in_more_than_10_days() {
        Item backstagePass = aBackstagePass(11, 5);

        updateQualityOf(backstagePass);

        assertThat(backstagePass.quality, is(equalTo(5 + 1)));
    }

    @Test
    void updateQuality_increases_quality_by_2_for_backstage_pass_sold_in_10_days_or_less() {
        Item backstagePass = aBackstagePass(10, 5);

        updateQualityOf(backstagePass);

        assertThat(backstagePass.quality, is(equalTo(5 + 2)));
    }

    @Test
    void updateQuality_increases_quality_by_3_for_backstage_pass_sold_in_5_days_or_less() {
        Item backstagePass = aBackstagePass(5, 5);

        updateQualityOf(backstagePass);

        assertThat(backstagePass.quality, is(equalTo(5 + 3)));
    }

    @Test
    void updateQuality_drops_quality_to_0_for_expired_backstage_pass() {
        Item backstagePass = aBackstagePass(0, 5);

        updateQualityOf(backstagePass);

        assertThat(backstagePass.quality, is(equalTo(0)));
    }

    @Test
    void updateQuality_cannot_increase_quality_over_50_when_increased_by_1() {
        Item agedBrie = agedBrie(10, 50);

        updateQualityOf(agedBrie);

        assertThat(agedBrie.quality, is(equalTo(50)));
    }

    @Test
    void updateQuality_cannot_increase_quality_over_50_when_increased_by_2() {
        Item agedBrie = agedBrie(0, 49);

        updateQualityOf(agedBrie);

        assertThat(agedBrie.quality, is(equalTo(50)));
    }

    @Test
    void updateQuality_cannot_increase_quality_over_50_when_increased_by_3() {
        Item backstagePass = aBackstagePass(5, 49);

        updateQualityOf(backstagePass);

        assertThat(backstagePass.quality, is(equalTo(50)));
    }

    // helper methods

    private static void updateQualityOf(Item... items) {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
    }

}
