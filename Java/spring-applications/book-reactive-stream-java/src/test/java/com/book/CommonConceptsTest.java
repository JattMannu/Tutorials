package com.book;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class CommonConceptsTest {

    void notes(){
        /*
           Hot and Cold Observables
                Hot = Cannot be repeated and starts creating data immediately regardless of subs, example: Web Request , Mouse movement
                Cold = Does not start until there is at least 1 sub

          Hot Observables are better suited for BACK PRESSURE.
          BACK PRESSURE Strategy : Drop, Throttle, Windows , Buffer
         */
    }
    @Test
    void filter(){
        int[] arr = new int[]{1,3,4,5,3,2,5,5,3,2,5,1,2,3,4};
        System.out.println(Arrays.stream(arr).anyMatch(value -> value == 2));
    }

}
