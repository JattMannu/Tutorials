package com.shopping.cart.manager;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Item {

    private String name;
    private BigDecimal value
}
