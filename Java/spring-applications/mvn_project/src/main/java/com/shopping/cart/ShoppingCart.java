package com.shopping.cart;

import java.util.Iterator;

public interface ShoppingCart {
    void addItem(Item item);
    int count();
    Iterable<Item> getCart();
}
