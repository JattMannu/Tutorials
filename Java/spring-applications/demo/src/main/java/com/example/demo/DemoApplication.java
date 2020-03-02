package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        TreeMap<Item, Integer> map = new TreeMap<>();

        Item apple = new Item("Apple" , "4.3");
        Item orange = new Item("Orange" , new BigDecimal("1.50" , new MathContext(2, RoundingMode.HALF_EVEN)));

        if (map.containsKey(apple))
            map.put(apple, 1);


        List<Item> cart = new LinkedList<Item>();
        cart.add(apple);
        cart.add(apple);
        cart.add(apple);
        cart.add(apple);
		cart.add(orange);
        cart.add(apple);
        cart.add(apple);


		cart.stream().forEach(item -> System.out.println(item.name + " " + item.price));

//		cart.stream().map(item ->{
//
//			BigDecimal total = total.add(item.price);
//		} );		cart.stream().map(item ->{
//
//			BigDecimal total = total.add(item.price);
//		} );
//
//		for (Item item : cart) {
//			total = total.add(item.price);
//		}


        BigDecimal total = getTotal(cart);
        System.out.println(total);
    }

    private BigDecimal getTotal(Iterable<Item> items) {
        BigDecimal  total = new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN);
        for (Iterator<Item> i = items.iterator(); i.hasNext() ; ) {
                total = total.add(i.next().price);
        }
        return total;
    }


    final class Item implements Comparable<Item> {

        final private String name;
		final private BigDecimal price;

        public Item(String name, BigDecimal price) {
            this.name = name;
            this.price = price.setScale(2,RoundingMode.HALF_EVEN);
        }

        public Item(String name, String price) {
            this(name , new BigDecimal(price));
        }

        public String getName() {
            return name;
        }

		public BigDecimal getPrice() {
			return price;
		}

        @Override
        public int compareTo(Item o) {
            return o.name.compareTo(this.name);
        }
    }
}
