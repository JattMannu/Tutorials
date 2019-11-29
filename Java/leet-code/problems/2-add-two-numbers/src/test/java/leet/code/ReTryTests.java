package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReTryTests {

    @Test
    public void add_0_to_0(){
        ListNode a = getListNodes(new int[]{0});
        ListNode b = getListNodes(new int[]{0});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 0);
    }


    @Test
    public void add_1_to_0(){
        ListNode a = getListNodes(new int[]{1});
        ListNode b = getListNodes(new int[]{0});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 1);
    }


    @Test
    public void add_1_to_1(){
        ListNode a = getListNodes(new int[]{1});
        ListNode b = getListNodes(new int[]{1});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 2);
    }


    @Test
    public void add_5_to_4(){
        ListNode a = getListNodes(new int[]{5});
        ListNode b = getListNodes(new int[]{4});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 9);
    }


    @Test
    public void add_5_to_5(){
        ListNode a = getListNodes(new int[]{5});
        ListNode b = getListNodes(new int[]{5});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 0);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
    }


    @Test
    public void add_99_to_99(){
        ListNode a = getListNodes(new int[]{9,9});
        ListNode b = getListNodes(new int[]{9,9});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 8);
        Assertions.assertEquals(addTwoNumbers.next.val , 9);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 1);
    }

    @Test
    public void add_999_to_999(){
        ListNode a = getListNodes(new int[]{9,9,9});
        ListNode b = getListNodes(new int[]{9,9,9});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 8);
        Assertions.assertEquals(addTwoNumbers.next.val , 9);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 9);
        Assertions.assertEquals(addTwoNumbers.next.next.next.val , 1);
    }

    @Test
    public void add_11_to_1(){
        ListNode a = getListNodes(new int[]{1,1});
        ListNode b = getListNodes(new int[]{1});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 2);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
    }

    @Test
    public void add_1_to_11(){
        ListNode a = getListNodes(new int[]{1});
        ListNode b = getListNodes(new int[]{1,1});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 2);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
    }

    //Explanation: 342 + 465 = 807.
    @Test
    public void add_342_to_465(){
        ListNode a = getListNodes(new int[]{3,4,2});
        ListNode b = getListNodes(new int[]{4,6,5});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 7);
        Assertions.assertEquals(addTwoNumbers.next.val , 0);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 8);
    }


    @Test
    public void add_916_to_0(){
        ListNode a = getListNodes(new int[]{9,1,6});
        ListNode b = getListNodes(new int[]{0});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 6);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 9);
    }

    @Test
    public void add_0_to_916(){
        ListNode a = getListNodes(new int[]{0});
        ListNode b = getListNodes(new int[]{9,1,6});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 6);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 9);
    }


    @Test
    public void add_0_to_916_null(){
        ListNode a = getListNodes(new int[]{0});
        ListNode b = getListNodes(new int[]{9,1,6});
        ListNode addTwoNumbers = new Solution().addTwoNumbers_v1(a, b);
        Assertions.assertEquals(addTwoNumbers.val , 6);
        Assertions.assertEquals(addTwoNumbers.next.val , 1);
        Assertions.assertEquals(addTwoNumbers.next.next.val , 9);
        Assertions.assertEquals(addTwoNumbers.next.next.next , null);
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
