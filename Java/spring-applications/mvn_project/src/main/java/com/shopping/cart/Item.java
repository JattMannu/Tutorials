package com.shopping.cart;



import java.math.BigDecimal;

public final class Item {
    final private String name;
    final private BigDecimal price;


    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, String price) {
       this(name,new BigDecimal(price));
    }


    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
