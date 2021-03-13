package com.gildedrose.items.helper;

@FunctionalInterface
interface ItemNameMatcher {

    boolean matches(String name);

}
