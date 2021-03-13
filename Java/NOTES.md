# Assumptions

The solution I have provided starts from these basic assumptions:

- I cannot change the Item class
- I'm not allowed to touch the package private `items` property in the `GuildedRose` class.
- I cannot change the semantics of the items passed to the `GuildedRose` constructor being used as output variables. I.e. I need to change the quality and sellIn attributes in-place.
- I assume the given set of approval tests does not exist, is incomplete or should not be used.

# Other changes I would like to make

If the above restrictions did not apply, then I would also like to change the following:

- Change `GuildedRose.updateQuality()` so it returns the list of changed `Item`S, so that the constructor parameter is no longer used as an output variable.
- Merge `Item` and `InventoryItem` into a single class and see if we can make that class immutable.
- Try to make most of the classes immutable.
- Extract Quality and SellIn value objects

# Design decisions

Some of the design decisions I chose to make and why I made them:

- I chose to do an object-oriented approach where we explicitly try to model an Item hierarchy with classes which wrap the `Item` class because I find it's the best fit for Java. Alternative approaches would be to not store the state inside of these wrapper classes, favor composition with decorator classes or do a more functional approach with lots of single function interfaces. 
- I explicitly separated the parsing of the type of an item from the construction of an `UpdateableItem` to adhere to the single responsibility principle. This introduced the need for an extra enum `ItemType`. This means more code needs to change when we add a new item type in the future, but it also makes it more explicit what different types of items our parsing supports.
- I wanted to give all of the small helper functions for increasing and decreasing quality a proper place close to where they were being used so I explicitly extracted an `InventoryItem` class. If the above restrictions did not apply, then I would probably move these to the `Item` class.
- Although not needed with the current requirements, I left room for dependencies to be injected in the future by providing two constructors. The first constructor takes the dependencies as an argument, the second one is a no-arg constructor which calls the first one with (the only) sensible default parameter. This way callers don't have to be bothered with constructing dependencies, but there is still room for extension. You can see examples in the classes `GildedRose` and `UpdateableInventoryItemFactory`.
