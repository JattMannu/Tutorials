package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void createItem(){
		DemoApplication d = new DemoApplication();
		DemoApplication.Item apple =d.new Item("apple", "2");

		Assertions.assertEquals(apple.getName() , "apple");
		Assertions.assertEquals(apple.getPrice(),  new BigDecimal("2").setScale(2, RoundingMode.HALF_EVEN));
	}

	@Test
	void item_is_immutable(){
		DemoApplication d = new DemoApplication();
		DemoApplication.Item apple =d.new Item("apple", "2");

		String name = apple.getName();
		name = "not apple";

		BigDecimal price = apple.getPrice();
		price.add(new BigDecimal("1"));

		Assertions.assertEquals(apple.getName() , "apple");
		Assertions.assertEquals(apple.getPrice(),  new BigDecimal("2").setScale(2, RoundingMode.HALF_EVEN));
	}

	@Test
	void able_to_add_one_item_to_cart(){


		ShoppingCart cart =  new ShoppingCart();

	}
}
