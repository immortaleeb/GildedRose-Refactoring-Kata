package com.gildedrose.items.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class ItemTypeParser {

    private static final Map<ItemNameMatcher, ItemType> ITEM_MATCHERS = new HashMap<>();
    static {
        ITEM_MATCHERS.put(ItemTypeParser::isLegendaryItem, ItemType.LEGENDARY_ITEM);
        ITEM_MATCHERS.put(ItemTypeParser::isConcertTicket, ItemType.CONCERT_TICKET);
        ITEM_MATCHERS.put(ItemTypeParser::isAgeableItem, ItemType.AGEABLE_ITEM);
        ITEM_MATCHERS.put(ItemTypeParser::isConjuredItem, ItemType.CONJURED_ITEM);
    }

    public ItemType parse(String name) {
        return findMatchingItemType(name)
                .orElse(ItemType.NORMAL_ITEM);
    }

    private Optional<ItemType> findMatchingItemType(String name) {
        return ITEM_MATCHERS.entrySet()
                .stream()
                .filter(matchesName(name))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    private static Predicate<Map.Entry<ItemNameMatcher, ItemType>> matchesName(String name) {
        return entry -> entry.getKey().matches(name);
    }

    private static boolean isLegendaryItem(String name) {
        return "Sulfuras, Hand of Ragnaros".equals(name);
    }

    private static boolean isConcertTicket(String name) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(name);
    }

    private static boolean isAgeableItem(String name) {
        return "Aged Brie".equals(name);
    }

    private static boolean isConjuredItem(String name) {
        return name.startsWith("Conjured ");
    }

}
