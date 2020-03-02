package com.shopping.cart;

import java.util.LinkedList;
import java.util.List;

public class MyShoppingCart implements ShoppingCart {

    private final List<Item> itemList;

    public MyShoppingCart() {
        this.itemList = new LinkedList<Item>();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public int count() {
        return itemList.size();
    }

    public Iterable getCart() {
        LinkedList<Item> a = new LinkedList<>(itemList);
        LinkedList<Item> b = new LinkedList<>(itemList);
        a.remove();
        return new LinkedList<Item>(itemList);
    }
}
