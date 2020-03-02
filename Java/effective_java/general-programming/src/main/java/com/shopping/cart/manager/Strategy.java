package com.shopping.cart.manager;

import java.math.BigDecimal;

public interface Strategy {

    BigDecimal compute(Cart cart);
}
