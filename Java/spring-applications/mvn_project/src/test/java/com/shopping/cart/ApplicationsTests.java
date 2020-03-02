package com.shopping.cart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ApplicationsTests {

    @Test
    void add_one_item_to_cart(){
        Item apple = new Item("apple", "1.3");
        ShoppingCart cart = new MyShoppingCart();
        cart.addItem(apple);

        for (Item item :cart.getCart()) {
            System.out.println(item);
        }
        Assertions.assertEquals(cart.count() , 1);

    }
}
