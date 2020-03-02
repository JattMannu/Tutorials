package com.shopping.cart.manager;


import lombok.Getter;

import java.math.BigDecimal;


public class ShoppingCart implements Cart{

    @Getter
    private BigDecimal total;
    @Getter
    private BigDecimal avg;

    public ShoppingCart() {
    }
}
