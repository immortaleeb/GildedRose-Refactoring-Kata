package com.gildedrose.items.factory;

@FunctionalInterface
interface ItemNameMatcher {

    boolean matches(String name);

}
