package leet.code;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void ex1() {
        ListNode a = getListNodes(new int[]{3, 4, 2});
        ListNode b = getListNodes(new int[]{4, 6, 5});
        ListNode addTwoNumbers = new Solution().addTwoNumbers(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 7);
        Assertions.assertEquals(addTwoNumbers.next.val , 0);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 8);
    }


    @Test
    void ex2() {
        ListNode a = getListNodes(new int[]{1, 9});
        ListNode b = getListNodes(new int[]{9});
        ListNode addTwoNumbers = new Solution().addTwoNumbers(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 8);
        Assertions.assertEquals(addTwoNumbers.next.val , 2);
    }

    @Test
    void ex3() {
        ListNode a = getListNodes(new int[]{1});
        ListNode b = getListNodes(new int[]{1});
        ListNode addTwoNumbers = new Solution().addTwoNumbers(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 2);
    }


    @Test
    void ex4() {
        ListNode a = getListNodes(new int[]{9,9});
        ListNode b = getListNodes(new int[]{1});
        ListNode addTwoNumbers = new Solution().addTwoNumbers(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 0);
        Assertions.assertEquals(addTwoNumbers.next.val , 0);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 1);
    }


    @Test
    void ex5() {
        ListNode a = getListNodes(new int[]{5});
        ListNode b = getListNodes(new int[]{5});
        ListNode addTwoNumbers = new Solution().addTwoNumbers(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 0);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
    }

    @Test
    void ex6() {
        ListNode a = getListNodes(new int[]{9,1,6});
        ListNode b = getListNodes(new int[]{0});
        ListNode addTwoNumbers = new Solution().addTwoNumbers(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 6);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 9);
    }


    private ListNode getListNodes(int[] numb1) {
        ListNode node_prev = new ListNode(numb1[0]);
        //Todo Check if the arraylist size is larger than 1
        for (int idx = 1; idx < numb1.length; idx++) {
            ListNode node = new ListNode(numb1[idx]);
            node.next = node_prev;
            node_prev = node;
        }
        return node_prev;
    }

}
